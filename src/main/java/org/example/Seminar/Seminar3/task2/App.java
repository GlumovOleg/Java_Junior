package org.example.Seminar.Seminar3.task2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerializablePerson oleg = new SerializablePerson("Oleg", 30, List.of("abcd", "wefwdwg"));
//        System.out.println(oleg);

        Path path = Path.of("serializable-person.txt");

        OutputStream outputStream = Files.newOutputStream(Path.of("serializable-person.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(oleg);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));
        Object deserializedOleg = objectInputStream.readObject();
        System.out.println(deserializedOleg);
        objectInputStream.close();

    }

}
