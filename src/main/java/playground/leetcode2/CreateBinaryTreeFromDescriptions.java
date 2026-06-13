package playground.leetcode2;

import playground.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreateBinaryTreeFromDescriptions {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> parents = new HashSet<>();
        Set<Integer> children = new HashSet<>();
        for (int[] des : descriptions) {
            int parent = des[0];
            int child = des[1];
            int isLeft = des[2];

            if (!nodes.containsKey(parent)) {
                nodes.put(parent, new TreeNode(parent));
            }
            parents.add(parent);

            if (!nodes.containsKey(child)) {
                nodes.put(child, new TreeNode(child));
            }

            children.add(child);
            if (isLeft == 1) {
                nodes.get(parent).left =  nodes.get(child);
            } else {
                nodes.get(parent).right =  nodes.get(child);
            }
        }
        parents.removeAll(children);
        return nodes.get(parents.iterator().next());
    }

}
