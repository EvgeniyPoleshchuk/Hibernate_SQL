package ru.netology.hibernate_sql.model;



import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;


@Getter
@Setter
@ToString
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
