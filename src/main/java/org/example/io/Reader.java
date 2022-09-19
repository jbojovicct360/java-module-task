package org.example.io;

import org.example.Solution;
import org.example.exception.NumberException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private boolean hasNumbers(String s) {
        for (int i = 0; i < s.length(); i++) {
            int charAscii = s.charAt(i);
            if(charAscii < 57 && charAscii > 48) {
                throw new NumberException();
            }
        }
        return true;
    }

    public void read() throws Exception {
        Solution solution = new Solution();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            String line = bufferedReader.readLine();
            while(line != null && hasNumbers(line)) {
                Writer.write(line, solution.solution(line));
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new Exception(e);
        }
    }

}