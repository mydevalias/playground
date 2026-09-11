package playground.leetcode3;

import playground.leetcode.TreeNode;

public class CountNodesEqualtoAverageofSubtree {

    int ret = 0;

    public int averageOfSubtree(TreeNode root) {
        count(root);
        return ret;
    }

    private Rc count(TreeNode node) {
        if (node == null) {
            return new Rc(0, 0);
        }
        Rc rleft = count(node.left);
        Rc rright = count(node.right);
        int sum = rleft.sum + rright.sum + node.val;
        int count = rleft.count + rright.count + 1;
        if (sum / count == node.val) {
            ret++;
        }
        return new Rc(count, sum);
    }

    record Rc(int count, int sum) {
    }

}
