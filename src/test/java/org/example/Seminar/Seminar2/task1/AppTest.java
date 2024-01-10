package org.example.Seminar.Seminar2.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    @BeforeEach // Тест перед тестом
    void beforeEachTest() {

    }

    @Test
    void testToString() {
        Person person = new Person("Oleg", 21);
        Assertions.assertEquals(person.toString(), "Oleg - [21]");
    }

    @AfterEach // Тест после теста
    void afterEachTest() {

    }

}
