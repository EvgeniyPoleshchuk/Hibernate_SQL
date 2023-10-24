package ru.netology.hibernate_sql.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Persons {

    @EmbeddedId
    private Contact contact;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;


    public Persons() {
    }

}
