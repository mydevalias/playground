package playground.leetcode;

import java.util.ArrayList;
import java.util.List;


public class BalanceABinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> all = new ArrayList<>();
        build(root, all);
        return rebuild(all, 0, all.size() - 1);
    }

    private TreeNode rebuild(List<Integer> all, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode tn = new TreeNode();
        tn.val = all.get(mid);
        tn.left = rebuild(all, start, mid - 1);
        tn.right = rebuild(all, mid + 1, end);
        return tn;
    }

    private void build(TreeNode node, List<Integer> all) {
        if (node == null) {
            return;
        }
        build(node.left, all);
        all.add(node.val);
        build(node.right, all);
    }

}
