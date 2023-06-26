package com.larsdotpy.personAPI.repository;

import com.larsdotpy.personAPI.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;
    Person person;

    @BeforeEach
    void setUp() {
        person = new Person("1", "John", "Jones",
                45, 180, 85.0,
                "USA", false);
        personRepository.save(person);
    }

    @AfterEach
    void tearDown() {
        person = null;
        personRepository.deleteAll();
    }


    //Testcase SUCCESS
    @Test
    void testFindByFirstName_Found(){
        List<Person> personList = personRepository.findByFirstName("John");
        assertThat(personList.get(0).getPersonId()).isEqualTo(person.getPersonId());
        assertThat(personList.get(0).getCountry())
                .isEqualTo(person.getCountry());
    }


    //Testcase FAILURE
    @Test
    void testFindByFirstName_NotFound(){
        List<Person> personList = personRepository.findByFirstName("Bob");
        assertThat(personList.isEmpty()).isTrue();
    }



}
