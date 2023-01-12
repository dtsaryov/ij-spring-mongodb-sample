package com.example.ijspringmongo.repository;

import com.example.ijspringmongo.model.Person;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, ObjectId> {

    @Query(value = "{ firstname: ?0 }", collation = "{ 'locale': 'en' }")
    List<Person> findByFirstname(String firstname);

    @Query(value = "{ lastname: ?0 }", fields = "{ firstname: 1, lastname: 1}")
    List<Person> findByLastname(String lastname);

    @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : $firstname } } }")
    List<PersonAggregate> groupByLastnameAndFirstnames();

    // property should be specified as '$property', e.g. '$age'
    @Aggregation("{ $group: { _id : $lastname, names : { $addToSet : ?0 } } }")
    List<PersonAggregate> groupByLastnameAnd(String property);

    @Aggregation("{ $group : { _id : null, total : { $sum : $age } } }")
    Long sumAge();

    @Aggregation("{ '$project': { '_id' : '$lastname' } }")
    List<String> findAllLastnames();

    @CountQuery("{ age: { $lt: ?0 } }")
    int countPersonsYoungerThan(int age);

    @DeleteQuery("{ age: { $gt: ?0 } }")
    void deletePersonOlderThan(int age);

    @ExistsQuery("{ firstname: ?0 }")
    boolean hasPersonWithFirstname(String firstname);

    @Update("{ '$inc' : { 'visits' : 1 } }")
    long findAndIncrementVisitsByLastname(String lastname);

    @Update("{ '$inc' : { 'visits' : ?1 } }")
    void findAndIncrementVisitsByLastname(String lastname, int increment);

    @Query("{ 'lastname' : ?0 }")
    @Update("{ '$inc' : { 'visits' : ?1 } }")
    void updateAllByLastname(String lastname, int increment);
}
