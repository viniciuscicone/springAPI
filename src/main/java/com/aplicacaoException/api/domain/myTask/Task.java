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


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String task;
    private String autor;


    public Task(TaskDTO data) {
        this.task = data.task;
        this.autor = data.autor;
    }
}
