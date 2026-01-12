package playground.leetcode;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class SmallestSubtreeWithAllTheDeepestNodes {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int max = findMaxDepth(root);
        return findMinAllMax(root, max);
    }

    private TreeNode findMinAllMax(TreeNode node, int current) {
        if (node == null) {
            return null;
        }

        if (current == 1) {
            return node;
        }

        TreeNode left = findMinAllMax(node.left, current - 1);
        TreeNode right = findMinAllMax(node.right, current - 1);

        if (left != null && right != null) {
            return node;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    private int findMaxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = findMaxDepth(node.left);
        int right = findMaxDepth((node.right));

        return Math.max(left, right) + 1;
    }


}
