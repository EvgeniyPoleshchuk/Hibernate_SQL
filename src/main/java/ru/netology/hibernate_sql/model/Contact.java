package ru.netology.hibernate_sql.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Embeddable
public class Contact  implements Serializable {

    private int age;
    private String name;
    private String surname;
}
