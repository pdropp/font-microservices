package br.com.SpringFont.Controllers;

import br.com.SpringFont.Services.PersonServices;
import br.com.SpringFont.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonControler {

    @Autowired
    private PersonServices service;
    //private personServices service = new PersonServices();

    @RequestMapping(value="{id}", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") String id) throws Exception{
     return service.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() throws Exception{
        return service.findAll();
    }

                           @RequestMapping(method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) throws Exception{
        return service.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) throws Exception{
        return service.update(person);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable(value = "id") String id) throws Exception{
         service.delete(id);
    }



}
