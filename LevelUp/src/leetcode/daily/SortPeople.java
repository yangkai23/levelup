package leetcode.daily;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class SortPeople {
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer,String> map=new HashMap<>();
        for(int i=0;i<names.length;i++){
            map.put(heights[i],names[i]);
        }
        int[] temp=new int[heights.length];
        System.arraycopy(heights,0,temp,0,heights.length);
        Arrays.sort(temp);
        reverse(temp);
       for(int i=0;i<names.length;i++){
           names[i]=map.get(temp[i]);
       }
       return names;
    }
    private int[] reverse(int[] ar){
        int len=ar.length;
        for(int i=0;i<len/2;i++){
            int temp=ar[i];
            ar[i]=ar[len-1-i];
            ar[len-1-i]=temp;
        }
        return ar;
    }
}
