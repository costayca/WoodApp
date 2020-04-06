package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.apache.tomcat.util.net.jsse.JSSEImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService implements Observer {

    private final PersonDao personDao;
    private Subject subject;
    private int currentDuration = 0;

    @Autowired
    public PersonService(@Qualifier("personPostgres") PersonDao personDao, @Qualifier("order") OrderService orderService) {
        this.personDao = personDao;
        this.subject = orderService;
        subject.registerObserver(this);
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }

    @Override
    public void update(int value) {
        currentDuration = value;
    }
}
