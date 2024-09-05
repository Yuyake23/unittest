package br.com.bruno.service.impl;

import br.com.bruno.model.Person;
import br.com.bruno.service.IPersonService;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) {
        person.setId(new AtomicLong().getAndIncrement());
        return person;
    }
}
