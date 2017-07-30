package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class Problem652 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem652 prob = new Problem652();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
        System.out.println(prob.findDuplicateSubtrees(root)); // [2, 4]
    }
}
