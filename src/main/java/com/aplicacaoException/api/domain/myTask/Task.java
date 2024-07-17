package com.aplicacaoException.api.domain.myTask;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Table(name="tarefa")
@Entity(name = "tarefa")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Data

public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Valid
    @NotNull
    @NotBlank
    @NotEmpty(message = "Campo invalido")
    @Size(min = 1, message = "{nome.Size}")
    private String task;
    @Valid
    @NotNull
    @NotBlank
    @NotEmpty(message = "Campo invalido")
    @Size(min = 1, message = "{nome.Size}")
    private String autor;


    public Task(TaskDTO data) {
        this.task = data.task();
        this.autor = data.autor();
    }
}
