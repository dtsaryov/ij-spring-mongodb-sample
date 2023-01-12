package com.example.ijspringmongo.repository;

import org.springframework.data.annotation.Id;

import java.util.List;

public class PersonAggregate {

    @Id
    private String lastname;
    private List<String> names;

    public PersonAggregate(String lastname, List<String> names) {
        this.lastname = lastname;
        this.names = names;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
