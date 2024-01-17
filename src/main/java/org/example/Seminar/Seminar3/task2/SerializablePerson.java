package org.example.Seminar.Seminar3.task2;

import java.io.Serializable;
import java.util.List;

public class SerializablePerson implements Serializable {

    private final String name;
    private int age;
    private List<String> tags;

    public SerializablePerson(String name,int age, List<String> tags) {
        this.name = name;
        this.age = age;
        this.tags = tags;
    }

    public SerializablePerson(String name, int age) {
        this(name, age, List.of());
    }

    public SerializablePerson(String name) {
        this(name, 20);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "SerializablePerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tags=" + tags +
                '}';
    }
}
