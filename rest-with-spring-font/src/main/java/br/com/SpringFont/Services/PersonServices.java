package br.com.SpringFont.Services;

import br.com.SpringFont.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll(){
        logger.info("Finding list people!");

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++ ) {
            Person person = mockPerson(i);
            persons.add(person);

        }
        return persons;

    }


    public Person create (Person person){


        logger.info("Create one person");
        return person;
    }

    public Person update(Person person){

        logger.info("update one person");
        return person;
    }

    public void delete(String  id){
        logger.info("Delete one person");

    }




    public Person findById(String id){

        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Pedro");
        person.setLastName("Paulo");
        person.setAddress("Recife - Pernambuco");
        person.setGender("Male");
        return person;
    }


    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in  " + i);
        person.setGender("Male");
        return person;
    }

}
