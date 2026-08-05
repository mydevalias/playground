package playground.leetcode3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElements {

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        int exp = nums[0];
        for (int i = 0; i < nums.length; i++) {
            while (exp != nums[i]) {
                res.add(exp);
                exp++;
            }
            exp++;
        }
        return res;
    }

}
