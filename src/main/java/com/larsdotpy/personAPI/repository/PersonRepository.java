package com.larsdotpy.personAPI.repository;

import com.larsdotpy.personAPI.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
        List<Person> findByFirstName(String firstName);
}
