package bits;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh
 * @since 24/11/25
 */
public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        int[] nums={0,1,1,1,1,1};
        System.out.println(prefixesDivBy5(nums));
    }
    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int sum = 0;
        for (int val : nums) {
           sum+=((sum<<1)+(val==1?1:0));
           result.add(sum%5==0);
        }
        return result;

    }
}
