package leetcode.daily;

public class NumOfWaysSplitArr {
    public static void main(String[] args) {
        int[] ar = {0, 0};
        System.out.println(waysToSplitArray(ar));
    }

    public static int waysToSplitArray(int[] nums) {
        long left = 0;
        long right = 0;
        for (int num : nums) {
            right += num;
        }
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            right -= nums[i];
            if (left >= right){
                res++;
            }
        }
        return res;
    }

}
