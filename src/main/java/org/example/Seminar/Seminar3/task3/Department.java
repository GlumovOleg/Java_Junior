package org.example.Seminar.Seminar3.task3;

import java.io.Serializable;

public class Department implements Serializable {

    private final String name;


    public Department(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "name='" + name + '\'' +
                '}';
    }
}
