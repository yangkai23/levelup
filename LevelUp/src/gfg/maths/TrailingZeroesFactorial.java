package gfg.maths;

import java.util.Scanner;

public class TrailingZeroesFactorial {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        int result=getNumOFZeroes(num);
        System.out.println("Result is : "+result);
        scanner.close();
    }

    private static int getNumOFZeroes(int num) {
        int ans=0;
        for(int i=5;i<=num;i=i*5){
            ans+=num/i;
        }
        return ans;
    }
}
