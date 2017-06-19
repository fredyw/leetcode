package leetcode;

/**
 * https://leetcode.com/problems/add-one-row-to-tree/
 */
public class Problem623 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        addOneRow(root, v, d, 1);
        return root;
    }

    private static void addOneRow(TreeNode node, int v, int d, int i) {
        if (node == null) {
            return;
        }
        if (d - 1 == i) {
            TreeNode tmpLeft = node.left;
            TreeNode tmpRight = node.right;
            node.left = new TreeNode(v);
            node.left.left = tmpLeft;
            node.right = new TreeNode(v);
            node.right.right = tmpRight;

            addOneRow(tmpLeft, v, d, i + 1);
            addOneRow(tmpRight, v, d, i + 1);
        } else {
            addOneRow(node.left, v, d, i + 1);
            addOneRow(node.right, v, d, i + 1);
        }
    }
}
