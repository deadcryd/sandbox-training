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
public class Actor implements Serializable {

    private static final long serialVersionUID = -618344546761247116L;

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Double growth;
    private Set<String> genres = new HashSet<>();
    private Integer totalFilms;
}
