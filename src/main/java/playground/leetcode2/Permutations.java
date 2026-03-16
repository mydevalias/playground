package playground.leetcode2;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        List<List<Integer>> result = new ArrayList<>();
        innerPermutation(0, result);
        return result;
    }

    static List<Integer> asList(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int n : nums) list.add(n);
        return list;
    }

    private void innerPermutation(int pos, List<List<Integer>> result) {
        if (pos == nums.length) {
            result.add(asList(nums));
        }
        for (int i = pos; i < nums.length; i++) {
            int tmp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = tmp;
            innerPermutation(pos + 1, result);
             tmp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = tmp;
        }

    }

}
