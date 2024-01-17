package org.example.Seminar.Seminar3.task1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class App {


    public static void main(String[] args) throws IOException {
//    InputStream, OutputStream

    Path path = Path.of("output.txt");


        OutputStream outputStream = Files.newOutputStream(path); //StandardOpenOption.APPEND - надстройка над файлом (открыть, прочитать, дописать, перезаписать и т.д.)
        outputStream.write("my content".getBytes());
        outputStream.close();

//        Замена для конструкции выше, которая автоматически закрывает Stream
//        try (OutputStream outputStream1 = Files.newOutputStream(path)) {
//            outputStream1.write("my left".getBytes());
//        }


//        InputStream inputStream = Files.newInputStream(path);
//        int read = inputStream.read();
//        byte[] bytes = inputStream.readAllBytes();
//        String content = new String(bytes);
//
//        inputStream.close();
//
//        System.out.println(content);
    }

}

