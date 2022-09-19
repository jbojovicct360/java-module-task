package org.example;

public class Solution {

    public int solution(String s) {
        int array[] = new int[5];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'B')
                array[0]++;
            if(s.charAt(i) == 'A')
                array[1]++;
            if(s.charAt(i) == 'L')
                array[2]++;
            if(s.charAt(i) == 'O')
                array[3]++;
            if(s.charAt(i) == 'N')
                array[4]++;
        }

        int counter = 0;
        while (array[0] > 0 && array[1] > 0 && array[2] > 1 && array[3] > 1 && array[4] > 0) {
            array[0]--;
            array[1]--;
            array[2] -= 2;
            array[3] -= 2;
            array[4]--;
            counter++;
        }
        return counter;
    }

}
