package ru.netology.hibernate_sql.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.hibernate_sql.model.Persons;
import ru.netology.hibernate_sql.repository.RepositoryDao;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServiceDao {
    private final RepositoryDao repository;

    public List<Persons> gerPersonsByCity(String city){
        return repository.getPersonsByCity(city);
    }
}
