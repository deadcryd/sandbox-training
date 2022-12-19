package org.deadcryd.unit_05.task_03.command;

import java.util.Map;
import java.util.Set;
import org.deadcryd.unit_05.task_03.domain.Film;
import org.deadcryd.unit_05.task_03.handler.InputHandler;
import org.deadcryd.unit_05.task_03.repository.FilmRepository;

public class FilmsBuilderCommands {

    private static final String HELP = """
        Список доступных команд:
        ~ /help
        ~ /add name
        ~ /add year
        ~ /add genre
        ~ /add actor
        ~ /save
        ~ /exit
        """;
    private final InputHandler inputHandler;
    private final Film film;
    private FilmRepository filmRepository;

    private FilmsBuilderCommands() {
        this.film = new Film();
        this.inputHandler = InputHandler.of("Создание фильма", generateCommands());
    }

    public static void start(FilmRepository filmRepository) {
        FilmsBuilderCommands filmsBuilderCommands = new FilmsBuilderCommands();
        filmsBuilderCommands.filmRepository = filmRepository;
        filmsBuilderCommands.inputHandler.run();
    }

    private Map<String, Runnable> generateCommands() {
        return Map.of(
            "/help", this::printHelp,
            "/add name", this::setName,
            "/add year", this::setYear,
            "/add genre", this::setGenres,
            "/add actor", this::setActors,
            "/save", this::saveExit,
            "/exit", this::exit
        );
    }

    private void printHelp() {
        System.out.print(HELP);
    }

    private void setName() {
        inputHandler.anotherInput("имени", film::setName, input -> input);
    }

    private void setYear() {
        inputHandler.anotherInput("года создания", film::setProductionYear, Integer::getInteger);
    }

    private void setGenres() {
        inputHandler.anotherInput("жанра", input -> {
            Set<String> genres = film.getGenres();
            genres.add(input);
            film.setGenres(genres);
        }, input -> input);
    }

    private void setActors() {
        ActorBuilderCommands.start(film);
    }

    private void saveExit() {
        filmRepository.addFilm(film);
        inputHandler.setContinueWork(false);
    }

    private void exit() {
        inputHandler.setContinueWork(false);
    }
}
