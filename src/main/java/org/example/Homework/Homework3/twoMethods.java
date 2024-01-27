package org.example.Homework.Homework3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class twoMethods {

    static void invateObj() {
        Person person = new Person("Oleg" , 16);

        String myFile = String.valueOf(Path.of(Person.getName() + "_" + UUID.randomUUID().toString()));
//        String fileName = myFile;
        System.out.println("Имя файла: " + myFile);

        try {
            Files.writeString(Path.of(myFile), Person.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            String read = Files.readString(Path.of(myFile));
            System.out.println(read);

            Files.delete(Path.of(myFile));
            System.out.println("Файл " + myFile + " успешно удалён");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
//визульки от мамульки
//    static void uploadFile (String fileName) {
//
//        try {
//            String read = Files.readString(Path.of("myFile"));
//            System.out.println(read);
//            Files.delete(Path.of("myFile"));
//            System.out.println("Файл " + fileName + " успешно удалён");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


}
