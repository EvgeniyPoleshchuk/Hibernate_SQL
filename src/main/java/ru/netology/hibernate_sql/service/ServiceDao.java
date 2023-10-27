package ru.netology.hibernate_sql.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate_sql.model.Persons;
import ru.netology.hibernate_sql.repository.RepositoryDao;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service

public class ServiceDao {
    private final RepositoryDao repository;

    public List<Persons> getPersonsByCity(String city){
        return repository.findPersonsByCity(city);
    }
    public List<Persons> getPersonsByAge(int age){
        return repository.findPersonsByAge(age);
    }
    public Optional<Persons> getPersonByNameAndSurname(String name,String surname){
        return repository.findPersonsByName(name,surname);
    }
}
