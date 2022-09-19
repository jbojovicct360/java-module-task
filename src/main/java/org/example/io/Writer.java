package org.example.io;

import org.example.exception.ZeroException;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void write(String word, int number) throws IOException {
        try (FileWriter fileWriter = new FileWriter("output.txt", true)) {
            if(number < 0)
                throw new ZeroException();
            fileWriter.write(word + " : " + String.valueOf(number) + '\n');
        } catch (IOException | ZeroException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }
    }

}
