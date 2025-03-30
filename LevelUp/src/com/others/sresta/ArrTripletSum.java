package com.others.sresta;

import java.util.List;

public class ArrTripletSum {
    public static long maximumTriplet(List<Long> array){
        if (array.size() < 3) {
            return 0;
        }
        long maxSum = array.get(0) + array.get(1) + array.get(2);
        for (int i = 1; i <= array.size() - 3; i++) {
            long currentSum = array.get(i) + array.get(i + 1) + array.get(i + 2);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
