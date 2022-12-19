package org.deadcryd.unit_05.task_03.command;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import org.deadcryd.unit_05.task_03.domain.Actor;
import org.deadcryd.unit_05.task_03.domain.Film;
import org.deadcryd.unit_05.task_03.handler.InputHandler;

public class ActorBuilderCommands {

    private static final String HELP = """
        Список доступных команд:
        ~ /help
        ~ /add name
        ~ /add surname
        ~ /add date
        ~ /add place
        ~ /add growth
        ~ /add genres
        ~ /add filmscount
        ~ /save
        ~ /exit
        """;
    private final InputHandler inputHandler;
    private final Actor actor;
    private Film film;

    private ActorBuilderCommands() {
        this.actor = new Actor();
        this.inputHandler = InputHandler.of("Создание Актера", generateCommands());
    }

    public static void start(Film film) {
        ActorBuilderCommands actorBuilderCommands = new ActorBuilderCommands();
        actorBuilderCommands.film = film;
        actorBuilderCommands.inputHandler.run();
    }

    private Map<String, Runnable> generateCommands() {
        return Map.of(
            "/help", this::printHelp,
            "/add name", this::setName,
            "/add surname", this::setSurname,
            "/add date", this::setDateOfBirth,
            "/add place", this::setPlaceOfBirth,
            "/add growth", this::setGrowth,
            "/add genres", this::setGenres,
            "/add filmscount", this::setTotalFilms,
            "/save", this::saveExit,
            "/exit", this::exit
        );
    }

    private void printHelp() {
        System.out.print(HELP);
    }

    private void setName() {
        inputHandler.anotherInput("имени", actor::setName, input -> input);
    }

    private void setSurname() {
        inputHandler.anotherInput("фамилии", actor::setSurname, input -> input);
    }

    private void setDateOfBirth() {
        inputHandler.anotherInput("даты рождения", actor::setDateOfBirth, LocalDate::parse);
    }

    private void setPlaceOfBirth() {
        inputHandler.anotherInput("места рождения", actor::setPlaceOfBirth, input -> input);
    }

    private void setGrowth() {
        inputHandler.anotherInput("инф. о росте", actor::setGrowth, Double::valueOf);
    }

    private void setGenres() {
        inputHandler.anotherInput("жанра", input -> {
            Set<String> genres = actor.getGenres();
            genres.add(input);
            actor.setGenres(genres);
        }, input -> input);
    }

    private void setTotalFilms() {
        inputHandler.anotherInput("инф. о кол-ве фильмов", actor::setTotalFilms, Integer::valueOf);
    }

    private void saveExit() {
        Set<Actor> actors = film.getActors();
        actors.add(actor);
        film.setActors(actors);
        inputHandler.setContinueWork(false);
    }

    private void exit() {
        inputHandler.setContinueWork(false);
    }
}
