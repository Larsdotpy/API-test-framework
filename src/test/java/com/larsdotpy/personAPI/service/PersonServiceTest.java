package com.larsdotpy.personAPI.service;

import com.larsdotpy.personAPI.model.Person;
import com.larsdotpy.personAPI.repository.PersonRepository;
import com.larsdotpy.personAPI.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;
    private PersonService personService;
    AutoCloseable autoCloseable;
    Person person;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        personService = new PersonServiceImpl(personRepository);
        person = new Person("1", "John", "Jones",
                45, 180, 85.0,
                "USA", false);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void testCreatePerson() {
        mock(Person.class);
        mock(PersonRepository.class);

        when(personRepository.save(person)).thenReturn(person);
        assertThat(personService.createPerson(person)).isEqualTo("Successfully created");
    }

    @Test
    void testUpdatePerson() {
        mock(Person.class);
        mock(PersonRepository.class);

        when(personRepository.save(person)).thenReturn(person);
        assertThat(personService.updatePerson(person)).isEqualTo("Successfully updated");
    }

    @Test
    void testDeletePerson() {
        mock(Person.class);
        mock(PersonRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(
                personRepository).deleteById(any());

        assertThat(personService.deletePerson("1")).isEqualTo("Successfully deleted");
    }

    @Test
    void testGetPerson() {
        mock(Person.class);
        mock(PersonRepository.class);

        when(personRepository.findById("1")).thenReturn(
                Optional.ofNullable(person)
        );

        assertThat(personService.getPerson("1").getFirstName())
                .isEqualTo(person.getFirstName());
        System.out.println("First name: " + person.getFirstName());
    }

    @Test
    void testGetAllPeople() {
        mock(Person.class);
        mock(PersonRepository.class);

        when(personRepository.findAll()).thenReturn(new ArrayList<Person>(Collections.singleton(person)));

        assertThat(personService.getAllPeople().get(0).getMarried())
                .isEqualTo(person.getMarried());
    }
}