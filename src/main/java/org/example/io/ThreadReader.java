package org.example.io;

import org.example.Solution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ThreadReader extends Thread {

    private String fileName;
    private Solution solution;

    public ThreadReader(String fileName) {
        this.fileName = fileName;
        solution = new Solution();
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/input/" + fileName))) {
            String line = bufferedReader.readLine();
            String word = null;
            if(line != null) {
                word = line;
            }
            line = bufferedReader.readLine();
            while (line != null) {
                Writer.writeString("Thread: " + Thread.currentThread().getName() + " - File: " + fileName + " - Word to find: " + word
                        + " - String to find word: " + line
                        + " - Solution: " + solution.twoWordsSolution(line, word));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
