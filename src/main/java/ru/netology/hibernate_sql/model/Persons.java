package ru.netology.hibernate_sql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persons {

    @EmbeddedId
    private Contact contact;
    @Column(nullable = false)
    private String city_of_living;

    public Persons() {
    }
    
}
