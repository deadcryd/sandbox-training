package org.deadcryd.unit_05.task_03.command;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import org.deadcryd.unit_05.task_03.domain.Film;
import org.deadcryd.unit_05.task_03.handler.InputHandler;
import org.deadcryd.unit_05.task_03.repository.FilmRepository;

public class MainCommands {

    private static final String HELP = """
        ~ Введите /menu {пункт меню} для того, чтобы перейти дальше.
        ~ Пункты меню:
        ~ 1. Вывести список фильмов
        ~ 2. Найти фильм
        ~ 3. Добавить фильм
        ~ 4. Загрузить стандартный набор фильмов
        ~ 5. Удалить фильм
        ~ 6. Очистить всё
        ~ Для выхода с сохранением используйте /exit
        """;

    private final Scanner scanner = new Scanner(System.in);
    private final InputHandler inputHandler;
    private FilmRepository filmRepository;

    private MainCommands() {
        this.inputHandler = InputHandler.of("Главная", generateCommands());
    }

    public static void start(String fileName) throws IOException, ClassNotFoundException {
        try (FilmRepository filmRepository = new FilmRepository(fileName)) {
            MainCommands mainCommands = new MainCommands();
            mainCommands.filmRepository = filmRepository;
            mainCommands.inputHandler.run();
        }
    }

    private Map<String, Runnable> generateCommands() {
        return Map.of(
            "/help", this::printHelp,
            "/menu 1", this::printFilms,
            "/menu 2", this::printFilmByName,
            "/menu 3", this::addFilm,
            "/menu 4", this::loadDefaultFilms,
            "/menu 5", this::removeFilmByName,
            "/menu 6", this::removeFilms,
            "/exit", this::exit
        );
    }

    private void printHelp() {
        System.out.print(HELP);
    }

    private void printFilms() {
        System.out.printf("~ Список фильмов с актерами в главных ролях:\n%s\n", filmRepository.findAll());
    }

    private void printFilmByName() {
        System.out.println("~ Введите название фильма:");

        String name = scanner.nextLine();
        Film film = filmRepository.findByName(name);

        if (film == null) {
            System.out.println("~ Фильм не найден!");
        } else {
            System.out.printf("~ Информация о фильме %s:\n%s\n", name, film);
        }
    }

    private void addFilm() {
        FilmsBuilderCommands.start(filmRepository);
    }

    private void removeFilmByName() {
        System.out.println("~ Введите название фильма:");

        String name = scanner.nextLine();

        if (!filmRepository.removeFilm(name)) {
            System.out.println("~ Фильм не найден!");
        } else {
            System.out.println("~ Фильм удален!");
        }
    }

    private void removeFilms() {
        filmRepository.removeAll();
        System.out.println("~ Список фильмов очищен!");
    }

    private void loadDefaultFilms() {
        Film.defaultFilms().forEach(filmRepository::addFilm);
        System.out.println("~ Стандартный набор фильмов загружен!");
    }

    private void exit() {
        inputHandler.setContinueWork(false);
    }
}
