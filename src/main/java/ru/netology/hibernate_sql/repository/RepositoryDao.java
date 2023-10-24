package ru.netology.hibernate_sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_sql.model.Contact;
import ru.netology.hibernate_sql.model.Persons;

import java.util.List;
import java.util.Optional;


@Repository
public interface RepositoryDao extends JpaRepository<Persons, Contact> {

    List<Persons> findPersonsByCityOfLiving(String city);

    List<Persons> findPersonsByContactAgeLessThanOrderByContactAsc(int age);

    Optional<Persons> findPersonsByContactNameAndContactSurname(String name, String surname);
}
