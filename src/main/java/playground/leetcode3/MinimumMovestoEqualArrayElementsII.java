package playground.leetcode3;

import java.util.Arrays;

public class MinimumMovestoEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for(int val:nums){
            res = res+Math.abs(nums[nums.length/2]-val);
        }
        return res;
    }

}
