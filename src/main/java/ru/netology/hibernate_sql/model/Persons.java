package ru.netology.hibernate_sql.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Persons {

    @EmbeddedId
    private Contact contact;
    @Column
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;

    public Persons() {
    }

}
