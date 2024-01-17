package org.example.Seminar.Seminar3.task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FlatMap {

    public static void main(String[] args) {

        List<Department> departments = new ArrayList<>();

        departments.stream()
                .flatMap(it -> it.getEmployees().stream())
                .toList();

        //другой вариант
        List<Employee> list = departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .toList();


//        List<String> langs = List.of("java", "c#", "python", "assembler", "pascal");
//
//        List<Integer> list = langs.stream()
//                .flatMap(it -> it.chars().boxed())  // каждая строка преобразована в массив (String -> Stream<Integer>)
////                .map(it -> it.toCharArray()) //Stream<char[]> - стрим массивов
//                .toList();// Stream<Integer>
//
//        System.out.println(list);//Stream<char[]> - стрим массивов
    }

        static class Department {
            private List<Employee> employees;

            public List<Employee> getEmployees() {
                return employees;
            }
        }

        static class Employee {

        }
}

