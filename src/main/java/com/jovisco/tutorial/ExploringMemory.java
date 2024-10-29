package com.jovisco.tutorial;

import java.time.ZonedDateTime;


public class ExploringMemory {

    // primitive types are always passed by value
    // the pointer to an object is passed by value. The data of an object is referenced by the pointer.
    public static void main(String[] args) {
        int localValue = 5;
        calculate(localValue);
        System.out.println(localValue);

        // "final" doesn't make the object immutable
        final Person person = new Person(1, "Smith", "John", ZonedDateTime.now());
        updatePerson(person);
        System.out.println(person)
        ;
        // use a record to create immutable objects
        final Student student = new Student(1, "Smith", "John", ZonedDateTime.now());
        System.out.println(student);
    }

    public static void calculate(int value) {
        value *= 100;
    }

    public static void updatePerson(Person person) {
        person.firstName = "Hansi";
    }
}

class Person {
    int ssn;
    String lastName;
    String firstName;
    ZonedDateTime dateOfBirth;

    Person(int ssn, String lastName, String firstName, ZonedDateTime dateOfBirth) {
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ssn=" + ssn +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

record Student(int ssn, String lastName, String firstName, ZonedDateTime dateOfBirth) {
    @Override
    public String toString() {
        return "Student{" +
                "ssn=" + ssn +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}