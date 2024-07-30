package com.others;


import java.util.Arrays;
import java.util.Scanner;

public class Addition{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(printArray(args));
//        System.out.println("Enter the length of array");
       /* int line = scanner.nextInt();
        int[] numbers = new int[line];
//        System.out.println(Arrays.toString(numbers));
       for (int i=0;i<line;i++){
           numbers[i]=scanner.nextInt();
       }
       scanner.nextLine();*/

        try{
            String age=args[0];
            age.length();
            int myAge=Integer.parseInt(age);
            System.out.println(myAge);
        }
        catch(NumberFormatException e){
            System.out.println("please enter an integer value");
        }
        catch(NullPointerException e){
            System.out.println("Age cannot be null!!");
        }
        catch (Exception e){
            System.out.println("Unknown error occurred!!");
        }
        System.out.println("Flow !!!");

//        System.out.println("enter grade ");
//       char grade=scanner.next().charAt(0);
//        System.out.println(Arrays.toString(numbers));
//        System.out.println(numbers);
//            for(int num:numbers)
//                System.out.println(num);
    }
    public static String printArray(Object[] a){
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append('}').toString();
            b.append(", ");
        }
    }
}
