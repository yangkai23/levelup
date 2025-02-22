package com.others.sresta;

import java.util.List;
import java.util.stream.Collectors;

public class HockeyDangerous {
    public static void main(String[] args) {
        List<Integer> list=List.of(0,1,0,0,1,1,0,1,1,1,1,0,1,1,0,1);
        List<String> list1 = list.stream().map(String::valueOf).toList();
        System.out.println(isDangerous(list1));
    }

    public static String isDangerous(List<String> list){
        if(list.size()<7){
            return "NO";
        }
        String allOnes="1111111";
        String allZeroes="0000000";
        String input=String.join("", list);
        int right=7;
        int left=0;
        int len=input.length();
        while (right<=len){
            if(input.substring(left,right).equals(allZeroes)||input.substring(left,right).equals(allOnes)){
                return "YES";
            }
            right++;
            left++;
        }
        return "NO";
    }
}
