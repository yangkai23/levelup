package com.others;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<List<Character>> keys = prepareKeys();
        int result = countSequence(keys, input.toUpperCase());
        System.out.println(result);
        scanner.close();

    }

    private static List<List<Character>> prepareKeys() {
        List<List<Character>> keyboardKeys = new LinkedList<>();

        char[] row2 = {'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'};
        char[] row3 = {'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'};
        char[] row4 = {'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
        char[] row5 = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        List<Character> list1 = new LinkedList<>();
        for (char key : row2) {
            list1.add(key);
        }
        keyboardKeys.add(list1);
        List<Character> list2 = new LinkedList<>();
        for (char key : row3) {
            list2.add(key);
        }
        keyboardKeys.add(list2);
        List<Character> list3 = new LinkedList<>();
        for (char key : row4) {
            list3.add(key);
            keyboardKeys.add(list3);
        }
        List<Character> list4 = new LinkedList<>();
        for (char key : row5) {
            list4.add(key);
        }
        keyboardKeys.add(list4);
        return keyboardKeys;
    }

    private static int countSequence(List<List<Character>> keys, String input) {
        if (input == null)
            return 0;
        int totalSeq = 0;
        int currSeq = 0;
        int len = input.length();
        for (int i = 1; i < len; i++) {
            char currChar = input.charAt(i);
            char prevChar = input.charAt(i - 1);
            int rowNum = searchKey(currChar, keys);
            if (rowNum == -1) {
                totalSeq += currSeq;
                currSeq = 0;
                continue;
            }
            List<Character> temp = keys.get(rowNum);
            int pos1 = temp.indexOf(currChar);
            int pos2 = temp.indexOf(prevChar);
            if ((pos1 != -1 && pos2 != -1) && Math.abs(pos1 - pos2) == 1 || Math.abs(pos1 - pos2) == 0) {
                if (currSeq == 0) {
                    currSeq++;
                }
                if (Character.isDigit(currChar)) {
                    currSeq++;
                }
            } else {
                totalSeq += currSeq;
                currSeq = 0;
            }
        }
        return totalSeq;
    }

    private static int searchKey(char c, List<List<Character>> keys) {
        for (int i = 0; i < keys.size(); i++) {
            for (int j = 0; j < keys.get(i).size(); j++) {
                if (keys.get(i).get(j) == c)
                    return i;
            }
        }
        return -1;
    }


}
