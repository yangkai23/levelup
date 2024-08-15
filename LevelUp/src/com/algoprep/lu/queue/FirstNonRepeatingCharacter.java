package com.algoprep.lu.queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(getUniqChar("abcbae"));
    }

    private static char getUniqChar(String input) {
        if (input == null || input.length() == 0) return 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        Queue<Character> characters = new LinkedList<>();
        int len = input.length();
        for (int i = 0; i < len; i++) {
            char c = input.charAt(i);
            characters.add(c);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        char c = ' ';
        while (!characters.isEmpty()) {
            if (freqMap.get(characters.peek()) > 1) characters.poll();
            else {
                c = characters.peek();
                break;
            }
        }
        return c;

    }

}
