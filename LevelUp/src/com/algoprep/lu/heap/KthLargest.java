package com.algoprep.lu.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public static void main(String[] args) {
        int[] ar = {5, 4, 8, 24, 1, 6};
        int k = 4;
        KthLargest kthLargest=new KthLargest();
        int result=kthLargest.findKthLargest(ar, k);
        System.out.println(result);
    }
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }
        int len = nums.length;
        for (int i = k; i < len; i++) {
            if (pq.peek() < nums[i]) {
                pq.offer(nums[i]);
                pq.poll();
            }
        }
        int con=k;
        return pq.peek();
    }
}
