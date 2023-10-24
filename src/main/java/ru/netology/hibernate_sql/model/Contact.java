package ru.netology.hibernate_sql.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Contact  implements Serializable {

    private int age;
    private String name;
    private String surname;
}
