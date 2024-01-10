package org.example.Seminar.Seminar2.task2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInteger {

//    int value();

//    int minValue();
    int minValue() default -100;

//    int maxValue();
    int maxValue() default 100;

}
