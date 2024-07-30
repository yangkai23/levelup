package com.algoprep.lu.sort;

import java.util.Arrays;

public class GoodInteger {
    public static void main(String[] args) {
        int[] ar ={-1,-4,3,5,-15,4};
//                {2, 0, 2, 3, 8, 3};
        System.out.println(getNumOfGoodInt(ar));
    }

    public static int getNumOfGoodInt(int[] ar) {
        int ans = 0;
        Arrays.sort(ar);
        int temp = 0;
        if (ar[0] == 0) {
            ans++;
        }
        int len = ar.length;

        for (int i = 1; i < len; i++) {
            if (ar[i] != ar[i - 1])
           temp = i;
            if (ar[i] == temp) {
                System.out.println(ar[i]);
                ans++;
            }

        }
        return ans;
    }
}
