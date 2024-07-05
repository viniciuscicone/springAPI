package com.booksproject.api.domain.lib;

import jakarta.persistence.*;
import lombok.*;

@Table(name="tarefa")
@Entity(name = "tarefa")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskClass {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String task;
    private String autor;


    public TaskClass(RequestTask data) {
        this.task = data.task();
        this.autor = data.autor();
    }
}
