package gfg.maths;

import java.util.Scanner;

public class LatinAlphaNumerical {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String latinAlphaNum = scanner.next();
        int result = getIntegerRepresentation(latinAlphaNum);
        System.out.println(result);
        scanner.close();
    }

    private static int getLatinAlphaEquivalent(String c) {
        switch (c) {
            case "I":
                return 1;
            case "V":
                return 5;
            case "X":
                return 10;
            case "L":
                return 50;
            case "C":
                return 100;
            case "D":
                return 500;
            case "M":
                return 1000;
            case "IV":
                return 4;
            case "IX":
                return 9;
            case "XL":
                return 40;
            case "XC":
                return 90;
            case "CD":
                return 400;
            case "CM":
                return 900;
            default:
                return 0;
        }

    }

    private static int getIntegerRepresentation(String latinAlphaNum) {
        int result = 0;
        char arr[] = latinAlphaNum.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) {
                if (isSubtractionApplicable(arr[i], arr[i + 1])) {
                    int eqv = getLatinAlphaEquivalent("" + arr[i] + arr[i + 1]);
                    i++;
                    if (i < arr.length - 2) {
                        if (getLatinAlphaEquivalent(String.valueOf(arr[i + 1])) == 0) {
                            result += Math.multiplyExact(eqv, 10);
                            continue;
                        }
                    }
                    result += eqv;
                    continue;
                }
                if (getLatinAlphaEquivalent(String.valueOf(arr[i + 1])) == 0) {
                    result += Math.multiplyExact(getLatinAlphaEquivalent(String.valueOf(arr[i])), 10);
                    continue;
                }
            }
            result += getLatinAlphaEquivalent(String.valueOf(arr[i]));
        }
        return result;
    }

    private static boolean isSubtractionApplicable(char a, char b) {
        return getLatinAlphaEquivalent("" + a + b) != 0;
    }
}
