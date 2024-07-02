package com.booksproject.api.domain.lib;

import jakarta.persistence.*;
import lombok.*;

@Table(name="library")
@Entity(name = "library")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Lib {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String autor;


    public Lib(RequestLib data) {
        this.name = data.name();
        this.autor = data.autor();
    }
}
