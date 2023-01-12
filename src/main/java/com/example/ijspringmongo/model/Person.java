package com.example.ijspringmongo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Person {

    @Field
    private final String firstname;
    @Field
    private final String lastname;
    @Field
    private final int age;
    @Field
    private final int visits;

    public Person(String firstname, String lastname, int age, int visits) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.visits = visits;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public int getVisits() {
        return visits;
    }
}
