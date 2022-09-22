package org.example;

import java.util.HashMap;

public class Solution {

    private int[] countBalloonLetters(String s) {
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
        return array;
    }

    private int ballonCharOccurance(int array[]) {
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

    public int solution(String s) {
        return ballonCharOccurance(countBalloonLetters(s));
    }

    private int[] getCharsFromString(String s) {
        int array[] = new int[256];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            array[(int) s.charAt(i)]++;
        }
        return array;
    }

    public int twoWordsSolution(String wordFromChar, String word) {
        int firstWordChar[] = getCharsFromString(wordFromChar);
        int secondWordChar[] = getCharsFromString(word);

        int count = Integer.MAX_VALUE;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            if (secondWordChar[(int) word.charAt(i)] != 0) {
                int currentLetterAccurance = firstWordChar[(int) word.charAt(i)] / secondWordChar[(int) word.charAt(i)];
                count = count > currentLetterAccurance ? currentLetterAccurance : count;
            }
        }
        return count;
    }

    private HashMap<Character, Integer> getCharsFromStringHashMap(String s) {
        HashMap<Character, Integer> characters = new HashMap<>();
        int stringLenght = s.length();
        for (int i = 0; i < stringLenght; i++) {
            if(characters.containsKey(s.charAt(i))) {
                int value = characters.get(s.charAt(i)).intValue();
                characters.replace(s.charAt(i), ++value);
            } else {
                characters.put(s.charAt(i), 1);
            }
        }
        return characters;
    }
    public int twoWordsHashMapSolution(String wordFromChar, String word) {
        HashMap<Character, Integer> word1 = getCharsFromStringHashMap(wordFromChar);
        HashMap<Character, Integer> word2 = getCharsFromStringHashMap(word);
        int count = Integer.MAX_VALUE;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            if(word1.containsKey(word.charAt(i)) && word2.get(word.charAt(i)).intValue() != 0) {
                int currentLetterAccurance = word1.get(word.charAt(i)).intValue() / word2.get(word.charAt(i)).intValue();
                count = count > currentLetterAccurance ? currentLetterAccurance : count;
            }
        }
        return count;
    }

}
