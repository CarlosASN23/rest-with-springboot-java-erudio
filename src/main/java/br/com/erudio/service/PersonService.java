package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public List<Person> findAll() {

        List<Person> persons = new ArrayList<>();

        for(int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    private Person mockPerson(int i) {

        logger.info("Finding all persons");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("Male");
        return person;
    }

    public Person findById(String id) {
        logger.info("Finding one Person...");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Carlos");
        person.setLastName("Nascimento");
        person.setAddress("Rua das alfandegas");
        person.setGender("Male");

        return person;
    }
}
