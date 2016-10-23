package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-iii/
 */
public class Problem437 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        IntRef ref = new IntRef();
        List<TreeNode> nodes = new ArrayList<>();
        allNodes(root, nodes);
        for (TreeNode node : nodes) {
            pathSum(node, sum, 0, ref);
        }
        return ref.result;
    }

    private static class IntRef {
        private int result;
    }

    private static void allNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        allNodes(root.left, nodes);
        allNodes(root.right, nodes);
    }

    private static void pathSum(TreeNode root, int sum, int accu, IntRef ref) {
        if (root == null) {
            return;
        }
        int newAccu = accu + root.val;
        if (newAccu == sum) {
            ref.result++;
        }
        pathSum(root.left, sum, newAccu, ref);
        pathSum(root.right, sum, newAccu, ref);
    }
}
