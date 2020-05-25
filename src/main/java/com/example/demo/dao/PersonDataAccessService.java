package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("personPostgres")
public class PersonDataAccessService implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(Person person) {
        final String sql = "INSERT INTO person (id, name, address, phone_number, password, username, role) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, person.getId(), person.getName(), person.getAddress(), person.getPhone_number(), person.getPassword(), person.getUsername(), person.getRole());
    }

    @Override
    public List<Person> selectAllPeople() {
        final String sql = "SELECT id, name, address, phone_number, password, username, role FROM person";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String phone_number = resultSet.getString("phone_number");
            String password = resultSet.getString("password");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");
            return new Person(id, name, address, phone_number, password, username, role);
        });
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "SELECT id, name, address, phone_number, password, username, role FROM person WHERE id = ?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID personId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String phone_number = resultSet.getString("phone_number");
            String password = resultSet.getString("password");
            String username = resultSet.getString("username");
            String role = resultSet.getString("role");
            return new Person(personId, name, address, phone_number, password, username, role);
        });
        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        final String sql = "DELETE FROM person WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        final String sql = "UPDATE person SET name = ?, address = ?, phone_number = ?, password= ?, username = ?, role = ? WHERE id = ?";
        return jdbcTemplate.update(sql, person.getName(), person.getAddress(), person.getPhone_number(), person.getPassword(), person.getUsername(), person.getRole(), id);
    }
}
