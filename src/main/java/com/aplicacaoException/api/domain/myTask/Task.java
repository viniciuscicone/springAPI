package com.aplicacaoException.api.domain.myTask;

import jakarta.persistence.*;

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
