package leetcode.strivers;

public class MajorityElement {
    //moore's voting algorithm
    public int majorityElement(int[] nums) {
        int count = 1, element = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (element == nums[i])
                count++;
            else {
                count--;
                if (count == 0) {
                    element = nums[i];
                    count = 1;
                }
            }
        }
        return element;
    }
}
