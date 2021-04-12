package com.knoma;

import com.knoma.pojo.Person;
import io.micronaut.http.annotation.*;

import javax.inject.Inject;

@Controller("/person")
public class PersonController {

    private PersonRepository repo;

    @Inject
    public PersonController(PersonRepository personRepository) {
        this.repo = personRepository;
    }

    @Get(uri="/", produces="application/json")
    public Iterable<Person> get() {
        return repo.findAll();
    }
}