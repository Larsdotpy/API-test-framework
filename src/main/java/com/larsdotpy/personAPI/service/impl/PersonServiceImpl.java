package com.larsdotpy.personAPI.service.impl;

import com.larsdotpy.personAPI.model.Person;
import com.larsdotpy.personAPI.repository.PersonRepository;
import com.larsdotpy.personAPI.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public String createPerson(Person person) {
        personRepository.save(person);
        return "Successfully created";
    }

    @Override
    public String updatePerson(Person person) {
        personRepository.save(person);
        return "Successfully updated";
    }

    @Override
    public String deletePerson(String personId) {
        personRepository.deleteById(personId);
        return "Successfully deleted";
    }

    @Override
    public Person getPerson(String personId) {
        return personRepository.findById(personId).get();
    }

    @Override
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }
}
