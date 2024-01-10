package org.example.Seminar.Seminar2.task1;

public class Person {

    private static long counter = 1;
    private final String name;
    private int age;


    private Person(String name) {
        this(name, 20);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person randomPerson() {
        return new Person("Peson #" + counter++);
    }
    @Override
    public String toString() {
        return String.format("%s - [%s]", name, age);
    }
}
