package ru.netology.hibernate_sql.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class Contact  implements Serializable {

    private String phone_number;
    private String name;
    private String surname;
}
