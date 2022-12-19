package org.deadcryd.unit_05.task_03.domain;

import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmsResource implements Serializable {

    private static final long serialVersionUID = -4113763405204496799L;

    private Set<Film> films;
}
