package playground.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumBack(candidates, target, 0, result, new ArrayList<>());
        return result;
    }

    public void combinationSumBack(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> current) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            combinationSumBack(candidates, target - candidates[i], i, result, current);
            current.removeLast();
        }
    }
}
