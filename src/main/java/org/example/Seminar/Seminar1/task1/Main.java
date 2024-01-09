package org.example.Seminar.Seminar1.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(List.of("java", "c#", "c++", "kotlin", "python", "pascal"));
        System.out.printf("Исходный список" + " " + strings + "\n");

        //через отдельный класс
        strings.sort(new StringLengthComparator());
        System.out.printf("Отсортированный список (отдельный класс) в порядке возростания:" + " " + strings  + "\n");

        //через анонимный класс
        Comparator<String> c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() < o2.length()){
                    return -1;
                }
                else if (o1.length() > o2.length()){
                    return 1;
                }
                return 0;
            }
        };
        strings.sort(c);
        System.out.printf("Отсортированный список (анонимный класс) в порядке возростания:" + " " + strings + "\n");

        // через лямду
        strings.sort((o1, o2) -> o1.length() - o2.length());
        System.out.printf("Отсортированный список (лямда) в порядке возростания:" + " " + strings  + "\n");


        //лямда ничего не принимает и возвращает
        MyInterface myInterface = () -> ThreadLocalRandom.current().nextInt(10);
        int result = myInterface.foo();
        System.out.println(result);

        //лямда принимает и ничего не возвращает
        MyInterface2 myInterface2 = it -> System.out.println(it);
        myInterface2.foo("abcde");

    }

    static class StringLengthComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() < o2.length()){
                return -1;
            }
                else if (o1.length() > o2.length()){
                    return 1;
                }
            return 0;
        }
    }

    interface MyInterface {

        int foo();
    }

    interface MyInterface2 {
        void foo(String arg);
    }


}
