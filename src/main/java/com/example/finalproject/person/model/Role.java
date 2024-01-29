package com.example.finalproject.person.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Вот для таких вещей лучше делать Enumeration в котором будут перечислены ВСЕ доступные роли в нашем приложении
    private String name;

    public Role(String name) {
        super();
        this.name=name;
    }
}
