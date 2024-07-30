package com.algoprep.lu.sort;

import java.util.Arrays;

public class OrderOfRemoval {
    public static void main(String[] args) {

    }

    /*ar[]={4,6,2,7}
    after sorting {2,4,6,7}

    remove 7 -> 2+4+6+7
    remove 6 -> 2+4+6
    remove 4 -> 2+4
    remove 2 -> 2
    if we observe the min value occured N-index times likwise for next min value*/
    public static int getMinCost(int[] ar){
        Arrays.sort(ar);
        int ans=0;
        int len= ar.length;
        for(int i=0;i<len;i++){
            ans+=Math.multiplyExact(ar[i],len-i);
        }
        return ans;
    }
}
