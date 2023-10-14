package com.algoprep.lu.msc;

public class WordReverse {
    public static void main(String[] args) {
        String s="kabali is back";
        String rev="";
        String[] str = s.split(" ");
        for(int i =str.length-1; i>=0;i--){
            rev+=str[i]+ " ";
        }
        System.out.println(rev);
    }
}
