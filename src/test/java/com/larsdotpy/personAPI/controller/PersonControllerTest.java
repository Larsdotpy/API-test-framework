package com.larsdotpy.personAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.larsdotpy.personAPI.model.Person;
import com.larsdotpy.personAPI.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PersonService personService;
    Person personOne;
    Person personTwo;
    List<Person> personList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        personOne = new Person("1", "John", "Jones",
                180, 85.0,
                "USA", "123456");

        personTwo = new Person("2", "Jack", "Debrois",
                195, 110.0,
                "UK", "654321");
        personList.add(personOne);
        personList.add(personTwo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetPersonDetails() throws Exception {
        when(personService.getPerson("1"))
                .thenReturn(personOne);
        this.mockMvc.perform(get("/person-api/1"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllPeopleDetails() throws Exception {
        when(personService.getAllPeople())
                .thenReturn(personList);
        this.mockMvc.perform(get("/person-api"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreatePersonDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(personOne);

        when(personService.createPerson(personOne))
                .thenReturn("Successfully created");
        this.mockMvc.perform(post("/person-api")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testUpdatePersonDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(personOne);

        when(personService.updatePerson(personOne))
                .thenReturn("Successfully updated");
        this.mockMvc.perform(put("/person-api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeletePersonDetails() throws Exception {
        when(personService.deletePerson("1"))
                .thenReturn("Successfully deleted");
        this.mockMvc.perform(delete("/person-api/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}