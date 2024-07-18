package gfg.maths;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LatinAlphaNumericalHashMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String latinAlphaNum = scanner.next();
        int result = getIntegerRepresentation(latinAlphaNum);
        System.out.println(result);
        scanner.close();
    }

    private static int getIntegerRepresentation(String latinAlphaNum) {
        Map<Character, Integer> romanMap = new HashMap<>();
        setRomanConstants(romanMap);
        int integerRepresentation = 0;
        int previous = 0;
        for (int i = 0; i < latinAlphaNum.length(); i++) {
            int current = romanMap.getOrDefault(latinAlphaNum.charAt(i), 0);
            if (current == 0) {
                previous *= 10;
            } else {
                if (current > previous) {
                    integerRepresentation -= 2 * previous;
                }
                integerRepresentation += current;
                previous = current;
            }
        }
        return integerRepresentation;
    }

    private static void setRomanConstants(Map<Character, Integer> map) {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
