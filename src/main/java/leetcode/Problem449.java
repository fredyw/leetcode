package leetcode;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/
 */
public class Problem449 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // TODO
        return null;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // TODO
        return null;
    }

    private static boolean equals(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 != null) {
            return false;
        }
        if (n1 != null && n2 == null) {
            return false;
        }
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1.val != n2.val) {
            return false;
        }
        return equals(n1.left, n2.left) && equals(n1.right, n2.right);
    }

    public static void main(String[] args) {
        Problem449 prob = new Problem449();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        root.right.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(10);

        System.out.println(equals(root, prob.deserialize(prob.serialize(root))));
    }
}
