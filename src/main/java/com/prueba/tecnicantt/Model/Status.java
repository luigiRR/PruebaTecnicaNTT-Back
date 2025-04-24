package com.prueba.tecnicantt.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="statuses")
@Getter @Setter
@NoArgsConstructor
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;

    public Status(Integer id) {
        this.id = id;
    }
}
