package playground.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargestSumInaBinaryTree {

    public long kthLargestLevelSum(TreeNode root, int k){
        ArrayList<Long> results = new ArrayList<>();
        levelOrder(root, results, 0);
        if(results.size()<=k) {
            results.sort(Collections.reverseOrder());
            return results.get(k-1);
        }
        return -1;
    }


    private void levelOrder(TreeNode node, List<Long> results, int level) {
        if (node == null) {
            return;
        }
        if (results.size() <= level) {
            for (int i = level; i < level + 1; i++) {
                results.add(0L);
            }
        }
        Long levelSum = results.get(level);

        levelSum += node.val;
        results.set(level, levelSum);
        levelOrder(node.left, results, level + 1);
        levelOrder(node.right, results, level + 1);
    }

}
