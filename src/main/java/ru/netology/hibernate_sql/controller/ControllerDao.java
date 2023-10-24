package ru.netology.hibernate_sql.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_sql.model.Persons;
import ru.netology.hibernate_sql.service.ServiceDao;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class ControllerDao {
    private final ServiceDao service;


    @GetMapping("/by-city")
    public List<Persons> personsList(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    public List<Persons> personsListByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/by-nameAndSurname")
    public Optional<Persons> person(@RequestParam("name") String name,
                                    @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

}
