package leetcode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class Problem222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        int leftLevel = countLeftLevel(root, 0);
        int rightLevel = countRightLevel(root, 0);
        if (leftLevel == rightLevel) {
            // 2^h - 1
            return (1 << leftLevel) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int countLeftLevel(TreeNode node, int level) {
        int count = 0;
        TreeNode n = node;
        while (n != null) {
            count++;
            n = n.left;
        }
        return count;
    }

    private int countRightLevel(TreeNode node, int level) {
        int count = 0;
        TreeNode n = node;
        while (n != null) {
            count++;
            n = n.right;
        }
        return count;
    }
}
