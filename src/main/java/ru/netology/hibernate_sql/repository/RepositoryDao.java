package ru.netology.hibernate_sql.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_sql.model.Persons;

import java.util.List;

@AllArgsConstructor
@Repository
public class RepositoryDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<Persons> getPersonsByCity(String city){

        return entityManager
                .createQuery("from Persons where city_of_living = :city", Persons.class).setParameter("city",city)
                .getResultList();

    }
}
