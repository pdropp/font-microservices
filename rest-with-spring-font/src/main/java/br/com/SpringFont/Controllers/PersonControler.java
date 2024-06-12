package br.com.SpringFont.Controllers;

import br.com.SpringFont.Services.PersonServices;
import br.com.SpringFont.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonControler {

    @Autowired
    private PersonServices service;
    //private personServices service = new PersonServices();

    @GetMapping(value="{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) throws Exception{
     return service.findById(id);
    }

    @GetMapping(MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() throws Exception{
        return service.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) throws Exception{
        return service.create(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) throws Exception{
        return service.update(person);
    }

    @DeleteMapping(value="{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception{
         service.delete(id);
         return ResponseEntity.noContent().build();
    }



}
