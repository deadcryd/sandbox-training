package org.deadcryd.unit_05.task_03.repository;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.deadcryd.unit_05.task_03.domain.Film;
import org.deadcryd.unit_05.task_03.domain.FilmsResource;

public class FilmRepository implements Closeable {

    private final String fileName;
    private Set<Film> films;


    public FilmRepository(String fileName) throws IOException, ClassNotFoundException {
        this.fileName = fileName;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            this.films = ((FilmsResource) objectInputStream.readObject()).getFilms();
        } catch (FileNotFoundException ex) {
            this.films = new HashSet<>();
        }
    }

    public boolean addFilm(Film film) {
        return films.add(film);
    }

    public List<Film> findAll() {
        return films.stream().toList();
    }

    public Film findByName(String name) {
        return films.stream()
            .filter(it -> Objects.equals(it.getName(), name))
            .findFirst()
            .orElse(null);
    }

    public boolean removeFilm(String name) {
        return films.removeIf(it -> Objects.equals(it.getName(), name));
    }

    public void removeAll() {
        films = new HashSet<>();
    }

    @Override
    public void close() throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(new FilmsResource(films));
        }
    }
}
