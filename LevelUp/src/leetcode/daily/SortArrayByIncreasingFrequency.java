package leetcode.daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByIncreasingFrequency {
    public static void main(String[] args) {
        int[] ar={-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString( frequencySort(ar)));
    }
    public static int[] frequencySort(int[] nums) {
      /*  int[] temp = new int[201];
        for (int val : nums) {
            if (val < 0) {
                temp[Math.abs(val) + 100]++;
            } else {
                temp[val]++;
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();

        Arrays.sort(temp);
        int pointer = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != 0) {

                if(i>100){
                    nums[pointer++] = Math.multiplyExact(i-100,-1);
                }
                nums[pointer++] = i;
            }
        }*/
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        Map.Entry<Integer,Integer>[] ar=new Map.Entry[map.size()];
        int pointer=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            ar[pointer++]=entry;
        }
//        Comparator<Map.Entry<Integer,Integer>> keyComparator=(a, b)->a.getKey()>b.getKey()?1:b.getKey()>a.getKey()?-1:0;
        Comparator<Map.Entry<Integer,Integer>> valueComparator=(a, b)->a.getValue()>b.getValue()?1:b.getValue()>a.getValue()?-1: b.getKey().compareTo(a.getKey());
        Arrays.sort(ar,valueComparator);

        System.out.println(Arrays.toString(ar));
        return constructResultantArray(ar,nums);
    }

    private static int[] constructResultantArray(Map.Entry<Integer, Integer>[] ar, int[] nums) {
        int pointer=0;
        for(int i=0;i<ar.length;i++){
            int entryVal=ar[i].getValue();
            while (entryVal>0){
                nums[pointer++]=ar[i].getKey();
                entryVal--;
            }
        }
        return nums;
    }

}
