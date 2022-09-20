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

    public static void writeIntoInput(String word) {
        try (FileWriter fileWriter = new FileWriter("input.txt", true)) {
            fileWriter.write(word);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
