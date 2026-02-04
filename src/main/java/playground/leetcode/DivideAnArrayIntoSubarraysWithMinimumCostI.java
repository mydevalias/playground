package playground.leetcode;

import java.util.Arrays;

public class DivideAnArrayIntoSubarraysWithMinimumCostI {

    public int minimumCost(int[] nums) {
        //This is suboptimal but fast to implement
        int first = nums[0];
        nums[0] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        return first + nums[0] + nums[1];
    }


}
