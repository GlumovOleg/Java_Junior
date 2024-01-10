package org.example.Seminar.Seminar2.task2;

public class App {

    public static void main(String[] args) {

        Annotations.MyClass myClass = new Annotations.MyClass();
        System.out.println(myClass.getNegative()); // 0
        System.out.println(myClass.getPositive()); // 0

        RandomIntegerProcessor.processObject(myClass);

        System.out.println(myClass.getNegative()); // <0
        System.out.println(myClass.getPositive()); // >0
    }



}
