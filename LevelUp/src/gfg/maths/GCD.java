package gfg.maths;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n1=scanner.nextInt();
        int n2=scanner.nextInt();
        int result=getGcd(n1,n2);
        System.out.println("Result is : "+result);
        scanner.close();
    }

    private static int getGcd(int n1, int n2) {
        if(n2==0)
            return n1;
        else
           return getGcd(n2,n1%n2);
    }
}
