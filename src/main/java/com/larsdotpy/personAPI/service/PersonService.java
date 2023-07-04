package com.larsdotpy.personAPI.service;

import com.larsdotpy.personAPI.model.Person;
import java.util.List;

public interface PersonService {
    public String createPerson(Person person);
    public String updatePerson(Person person);
    public String deletePerson(String personId);
    public Person getPerson(String personId);
    public List<Person> getAllPeople();
}
