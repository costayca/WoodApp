package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

public interface PersonDao {

    int insertPerson(Person person);

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}
