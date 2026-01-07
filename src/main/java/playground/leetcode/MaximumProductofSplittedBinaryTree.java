package playground.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumProductofSplittedBinaryTree {
    Map<TreeNode, Long> subsums;
    long max = Integer.MIN_VALUE;
    static final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        this.subsums = new HashMap<>();
        long totals = subtreesumm(root);
        maxProducs(root, totals);
        return (int) (max % MOD);
    }

    private void maxProducs(TreeNode node, long totals) {
        if (node == null) {
            return;
        }
        Long sub = subsums.get(node);
        max = Math.max(sub * (totals - sub), max);
        maxProducs(node.left, totals);
        maxProducs(node.right, totals);
    }


    private long subtreesumm(TreeNode node) {
        if (node == null) {
            return 0;
        }
        long leftSum = subtreesumm(node.left);
        long rigtSum = subtreesumm((node.right));

        long total = leftSum + rigtSum + node.val;
        subsums.put(node, total);
        return total;
    }

}
