package leetcode.daily;

public class OnesComplement {
    public static void main(String[] args) {
        int val = 5;
        int result = getComplement(val);
        System.out.println(result);
    }

    private static int getComplement(int num) {
       int len= (int)(Math.log(num)/Math.log(2))+1;
       int mask=(1<<len)-1;
       return num^mask;
    }
}
