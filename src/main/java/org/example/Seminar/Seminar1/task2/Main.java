package org.example.Seminar.Seminar1.task2;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        // void run(); - ничего не принимаю, ничего не возвращаю --> Runnable

        Runnable runnable = () -> System.out.println(ThreadLocalRandom.current().nextInt(100));
        for (int i = 0; i < 10; i++) {
            runnable.run();
        }

        // T get(); - ничего не принимаю, что то возвращаю --> Supplier
        // interface Interface <T> {
        //  T get();
        //  }

        // void accept(T value); - что то принимаю, ничего не возвращаю --> Consumer

        // R apply(T value); - что то принимаю, что то возвращаю --> Function

        Function<String, Integer> stringLengthExtractor = arg -> arg.length();
        System.out.println(stringLengthExtractor.apply("abcde"));
        System.out.println(stringLengthExtractor.apply("java"));
        System.out.println(stringLengthExtractor.apply("python"));

//        UnaryOperator<String> тоже самое, что и Function<String, String>
        Function<String, String> f = it -> "Добрый день, " + it.toUpperCase() + "!";
        System.out.println(f.apply("Олег"));
    }

}
