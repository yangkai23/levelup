package com.others.heaps;

import java.util.*;

public class TopNFrequentElements {
    public static void main(String[] args) {
        int[] ar = {1, 4, 4, 1, 6, 8, 7, 7, 6, 1, 4, 1, 64, 4, 1, 4, 1};
        int n = 2;
        System.out.println(Arrays.toString(getTopNElements(ar, 2)));
    }

    private static int[] getTopNElements(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }

        int[] freq = new int[max - min + 1];

        for (int n : nums) {
            freq[n - min]++;
        }

        ArrayList<Integer>[] freqArr = new ArrayList[nums.length+1];

        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (freqArr[freq[i]] == null) {
                    freqArr[freq[i]] = new ArrayList<Integer>();
                }
                freqArr[freq[i]].add(i + min);
            }
        }

        int[] res = new int[k];

        int kk = 0;
        for (int i=freqArr.length-1; i>=0; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    res[kk] = freqArr[i].get(j);
                    kk++;

                    if (kk >= k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }

    /*
    *  Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int val : nums) {
            frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> integerIntegerEntry : frequencyMap.entrySet()) {
            minHeap.offer(integerIntegerEntry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result =new int[minHeap.size()];
        for(int i=k-1;i>=0;i--){
            result[i]= Objects.requireNonNull(minHeap.poll(),"cannot be null").getKey();
        }
        return result;
    * */
}
