package playground.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumLevelSumOfaBinaryTree {

    public int maxLevelSum(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        levelOrder(root, results, 0);
        return maxIndex(results);
    }

    public int maxIndex(List<Integer> results) {
        int maxIndex = 0;
        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) > results.get(maxIndex)) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private void levelOrder(TreeNode node, List<Integer> results, int level) {
        if (node == null) {
            return;
        }
        if (results.size() <= level) {
            for (int i = level; i < level + 1; i++) {
                results.add(0);
            }
        }
        Integer levelSum = results.get(level);

        levelSum += node.val;
        results.set(level, levelSum);
        levelOrder(node.left, results, level + 1);
        levelOrder(node.right, results, level + 1);
    }


}
