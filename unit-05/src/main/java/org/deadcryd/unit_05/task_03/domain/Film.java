package org.deadcryd.unit_05.task_03.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film implements Serializable {

    private static final long serialVersionUID = 1678396384426365405L;

    private String name;
    private Integer productionYear;
    private Set<String> genres = new HashSet<>();
    private Set<Actor> actors = new HashSet<>();

    public static Set<Film> defaultFilms() {
        Actor tomHanks = Actor.builder()
            .name("Том")
            .surname("Хэнкс")
            .dateOfBirth(LocalDate.of(1956, 6, 9))
            .placeOfBirth("Конкорд, Калифорния, США")
            .growth(1.83)
            .genres(Set.of("комедия", "драма", "документальный"))
            .totalFilms(407)
            .build();
        Film greenMile = Film.builder()
            .name("Зеленая миля")
            .productionYear(1999)
            .genres(Set.of("драма", "фэнтези", "документальный"))
            .actors(Set.of(tomHanks))
            .build();
        Film forrestGump = Film.builder()
            .name("Форрест Гамп")
            .productionYear(1994)
            .genres(Set.of("драма", "комедия"))
            .actors(Set.of(tomHanks))
            .build();
        return Set.of(greenMile, forrestGump);
    }
}
