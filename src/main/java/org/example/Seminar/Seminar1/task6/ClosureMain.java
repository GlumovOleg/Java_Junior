package org.example.Seminar.Seminar1.task6;

import java.util.concurrent.atomic.AtomicInteger;

public class ClosureMain {

    public static void main(String[] args) {
        Runnable runnable = xPrinter();
        runnable.run();
    }

    private static Runnable xPrinter() {
//        final int x = 5;
//        Runnable runnable = () -> {
//            System.out.println(x);
//        };

//        int[]xx = new int[1];
//        xx[0] = 5;
//        Runnable runnable = () -> {
//            System.out.println(xx[0]);
//        };
//        xx[0] = 7;

        AtomicInteger atomicInteger = new AtomicInteger(1);
        Runnable runnable = () -> {
            System.out.println(atomicInteger.get());
        };
        atomicInteger.set(8);

    return runnable;
    }

}
