package ru.netology.hibernate_sql.controller;


import jakarta.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @RolesAllowed({"WRITE"})
    public List<Persons> personsList(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @GetMapping("/by-age")
    @Secured({"ROLE_READ"})
    public List<Persons> personsListByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age);
    }

    @GetMapping("/by-nameAndSurname")
    @PreAuthorize("hasAnyRole('WRITE','READ')")
    public Optional<Persons> personsByNameAndSurname(@RequestParam("name") String name,
                                                     @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }
    @GetMapping("/hello")
    @PreAuthorize("#username == authentication.principal.username")
    public String hello2(@RequestParam("name") String username) {
        return "hello " + username;
    }

}
