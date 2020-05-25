package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Person {

    private final UUID id;
    @NotNull
    private final String name;
    @NotNull
    private final String address;
    @NotNull
    private final String phone_number;
    @NotNull
    private final String password;
    @NotNull
    private final String username;
    @NotNull
    private final String role;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("address") String address
            , @JsonProperty("phone_number") String phone_number, @JsonProperty("password") String password, @JsonProperty("username") String username, @JsonProperty("role") String role) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
