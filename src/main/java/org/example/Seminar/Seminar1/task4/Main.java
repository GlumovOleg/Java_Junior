package org.example.Seminar.Seminar1.task4;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<Person> personGenerator = Person::new;

        Person person = personGenerator.get();
        System.out.println(person);
        person = personGenerator.get();
        System.out.println(person);


        Function<String, Person> personFunction = Person::new;
        Person person1 = personFunction.apply("Igor");
        System.out.println(person1);
        person1 = personFunction.apply("OWNER");
        System.out.println(person1);


    }

    public static class Person{
        public static long counter = 1L;
        private String name;
        private Supplier<String> wordGenerator;
        public Person() {
            name = "Person #" + counter++;
        }

        public Person(String name) {
            this.name = name;
            this.wordGenerator = this::generateNextWord;
        }

        public void saySomething(){
            System.out.println(wordGenerator.get());
        }

        private String generateNextWord(){
            return "EFFECTIVE RANDOM WORD";
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
