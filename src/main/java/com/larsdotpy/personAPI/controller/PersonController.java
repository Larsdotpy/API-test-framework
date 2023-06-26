package com.larsdotpy.personAPI.controller;

import com.larsdotpy.personAPI.model.Person;
import com.larsdotpy.personAPI.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-api")
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{personId}")
    public Person getPersonDetails(@PathVariable("personId") String personId){
        return personService.getPerson(personId);
    }

    @GetMapping()
    public List<Person> getAllPeopleDetails(){
        return personService.getAllPeople();
    }

    @PostMapping
    public String createPersonDetails(@RequestBody Person person){
        personService.createPerson(person);
        return "New person successfully created.";
    }

    @PutMapping
    public String updatePersonDetails(@RequestBody Person person){
        personService.updatePerson(person);
        return "Person successfully updated.";
    }

    @DeleteMapping("{personId}")
    public String deletePersonDetails(@PathVariable("personId") String personId){
        personService.deletePerson(personId);
        return "Person successfully deleted.";
    }

}
