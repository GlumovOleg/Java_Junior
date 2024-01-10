package org.example.Seminar.Seminar2.task2;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerProcessor {

    //Найти все int - поля класса с аннотацией RandomInteger и заполнить их рандомными значениями
    public static void processObject(Object object) {

        Class<?> objectClass = object.getClass();
        for (Field declaredField : objectClass.getDeclaredFields()) {
//            if (declaredField.getType() == int.class && declaredField.isAnnotationPresent(RandomInteger.class)) {
              if (int.class.isAssignableFrom(declaredField.getType()) && declaredField.isAnnotationPresent(RandomInteger.class)) {
                  RandomInteger annotation = declaredField.getAnnotation(RandomInteger.class);
                  int minValue = annotation.minValue();
                  int maxValue = annotation.maxValue();

                  // [4, 7] => 4 + (0, 3)
                  int randomValue = minValue + ThreadLocalRandom.current().nextInt(maxValue - minValue);
                  declaredField.setAccessible(true);

                  try {
                    declaredField.set(object, randomValue);

                  }catch (IllegalAccessException e) {
                      throw new RuntimeException(e.getMessage(), e);
                  }
              }
        }
    }
}
