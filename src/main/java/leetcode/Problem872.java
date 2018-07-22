package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class Problem872 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        collectLeafValues(root1, leaves1);
        List<Integer> leaves2 = new ArrayList<>();
        collectLeafValues(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private static void collectLeafValues(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        } else {
            collectLeafValues(root.left, leaves);
            collectLeafValues(root.right, leaves);
        }
    }
}
