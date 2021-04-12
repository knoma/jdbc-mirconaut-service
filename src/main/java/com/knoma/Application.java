package com.knoma;

import com.knoma.pojo.Person;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class Application {

    private PersonRepository repository;

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    public Application(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    @EventListener
    void startup(StartupEvent startupEvent) {
        repository.saveAll(List.of(new Person("test", "test123@apple.com"),
                new Person("test111", "test1111123@apple.com")));
    }
}
