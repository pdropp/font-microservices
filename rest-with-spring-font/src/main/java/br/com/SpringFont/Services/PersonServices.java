package br.com.SpringFont.Services;

import br.com.SpringFont.Exeception.ResourceNotFoundExeception;
import br.com.SpringFont.Repository.PersonRepository;
import br.com.SpringFont.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.logging.Logger;


@Service
public class PersonServices {


    private final Logger logger = Logger.getLogger(PersonServices.class.getName());


    @Autowired
    PersonRepository repository;
    public List<Person> findAll(){

        return repository.findAll();

    }


    public Person findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Erro ao tentar buscar pelo ID!"));

    }

    public Person create (Person person){


        logger.info("Create one person");
        return repository.save(person);
    }

    public Person update(Person person){

        logger.info("update one person");
        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundExeception("Erro ao tentar buscar pelo ID!"));


        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);

    }

    public void delete(Long  id){
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeception("Erro ao tentar buscar pelo ID!"));

        repository.delete(entity);
    }


}
