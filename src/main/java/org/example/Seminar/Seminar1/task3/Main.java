package org.example.Seminar.Seminar1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        //String --> Integer
        Function<String, Integer> stringLengthExtractor = String::length;
//        or
//        Function<String, Integer> stringLengthExtractor = Main::extractStringLength;
        System.out.println(stringLengthExtractor.apply("abcde"));
        System.out.println(stringLengthExtractor.apply("java"));
        System.out.println(stringLengthExtractor.apply("python"));

        Runnable run = Main::printRandomNumberLessThan100;
        System.out.println("Список из 10-ти рандомных чисел от 1 до 99: ");
        for (int i = 0; i < 10; i++) {
            run.run();
        }

        Supplier<Integer> javaLengthGetter = "java"::length;
        System.out.println("\n" + javaLengthGetter.get());
        System.out.println(javaLengthGetter.get());
        System.out.println(javaLengthGetter.get());
        System.out.println(javaLengthGetter.get());


        //String --> Boolean
        Predicate<String> isBestLanguage = "java"::equals;
        System.out.println(isBestLanguage.test("java"));
        System.out.println(isBestLanguage.test("kotlin"));
        System.out.println(isBestLanguage.test("python"));

        List<String> strings = new ArrayList<>(List.of("java", "c#", "c++", "kotlin", "python", "pascal"));
        System.out.printf("\n" + "Исходный список" + " " + strings);
        strings.sort(Main::myComparator);
        System.out.printf("\n" + "Отсортированный список" + " " + strings + "\n");

    }
    //Function<String, Integer>
    static Integer extractStringLength(String arg) {
        return arg.length();
    }

    //Runnable
    static void printRandomNumberLessThan100() {
        System.out.print(ThreadLocalRandom.current().nextInt(100) + " ");
    }

    //Comparator<String>
    static int myComparator(String a, String b) {
        return a.length() - b.length();
    }
}
