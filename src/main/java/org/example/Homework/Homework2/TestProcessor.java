package org.example.Homework.Homework2;

import org.example.Homework.Homework2.Annotations.AfterEach;
import org.example.Homework.Homework2.Annotations.Skip;
import org.example.Homework.Homework2.Annotations.Test;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestProcessor {

    /**
     * Данный метод находит все void методы без аргументов в классе и запускает их.
     *
     * Для запуска создаётся тестовый объект с помощью конструктора без аргументов.
     * @param testClass
     */

    public static void runTest(Class<?> testClass){
        final Constructor<?> declaredConstructor;
        try {
        declaredConstructor = testClass.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Для класса \"" + testClass.getName() + "\" не найден конструктор без аргументов");
        }

        final Object testObject;
        try {
            testObject = declaredConstructor.newInstance();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось создать объект класса \"" + testClass.getName() + "\"");
        }

        List<Method> beforeEachMethods = Arrays.stream(testClass.getDeclaredMethods()).
                filter(it -> it.isAnnotationPresent(BeforeEach.class))
                .toList();

        List<Method> afterEachMethods = Arrays.stream(testClass.getDeclaredMethods()).
                filter(it -> it.isAnnotationPresent(AfterEach.class))
                .toList();

        /* Альтернативный вариант
        List<Method> methods = new ArrayList<>();
        for (Method method : testClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class) && !method.isAnnotationPresent(Skip.class)){
                checkTestMethod(method);
                methods.add(method)
            }
        }

        methods.sort(Comparator.comparingInt(it -> it.getAnnotation(Test.class).order()));
        */

        List<Method> methods = Arrays.stream(testClass.getDeclaredMethods())
                        .filter(it -> it.isAnnotationPresent(Test.class) && !it.isAnnotationPresent(Skip.class))
                                .peek(TestProcessor::checkTestMethod)
                                        .sorted(Comparator.comparingInt(it -> it.getAnnotation(Test.class).order()))
                .toList();



        methods.forEach(it -> {
            beforeEachMethods.forEach(x -> runTest(x, testObject));
            runTest(it, testObject);
            afterEachMethods.forEach(x -> runTest(x, testObject));

        });
    }

    private static void checkTestMethod(Method method) {

        if (!method.getReturnType().isAssignableFrom(void.class) || method.getParameterCount() != 0) {
            throw new IllegalArgumentException("Метод \"" + method.getName() + "\" должен быть void и не иметь аргументов" );

        }

    }

    private static void runTest(Method testMethod, Object testObject) {
        try {
            testMethod.invoke(testObject);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException("Не удалось запустить тестовый метод \"" + testMethod.getName() + "\"");
        }
    }
}
