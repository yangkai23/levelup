package leetcode.daily;


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] ar = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(ar));
    }
//Two pointer approach
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int lastSeenMaxValueIndex = 0;
        int i = 1;
        int count = 1;
        while (i < nums.length) {
            if (nums[i] > max) {
                max = Math.max(max, nums[i]);
                count++;
                if (lastSeenMaxValueIndex + 1 != i) {
                    nums[lastSeenMaxValueIndex+1]=nums[i];
                    lastSeenMaxValueIndex = lastSeenMaxValueIndex + 1;
                }
                else {
                    lastSeenMaxValueIndex=i;
                }
            }
            i++;
        }
        return count;
    }


}
