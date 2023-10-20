package ru.netology.hibernate_sql.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hibernate_sql.model.Persons;
import ru.netology.hibernate_sql.service.ServiceDao;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/persons")
public class ControllerDao {
    private final ServiceDao service;


@GetMapping("/by-city")
    public List<Persons> personsList(@RequestParam("city") String city){
    return service.gerPersonsByCity(city);
}

}
