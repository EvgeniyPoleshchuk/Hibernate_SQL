package ru.netology.hibernate_sql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_sql.model.Contact;
import ru.netology.hibernate_sql.model.Persons;


import java.util.List;
import java.util.Optional;



@Repository
public interface RepositoryDao extends JpaRepository<Persons, Contact> {
    @Query("select c from Persons c where c.cityOfLiving = :city")
    List<Persons> findPersonsByCity(@Param("city") String city);
    @Query("select a from Persons a where a.contact.age < :age order by a.contact.age asc ")
    List<Persons> findPersonsByAge(@Param("age") int age);
    @Query( "select a from Persons a where a.contact.name = :name and a.contact.surname = :surname")
    Optional<Persons> findPersonsByName(@Param("name") String name,@Param("surname") String surname);


}
