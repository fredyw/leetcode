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

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        // TODO
        return root;
    }

    public static void main(String[] args) {
        Problem623 prob = new Problem623();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        System.out.println(prob.addOneRow(root, 1, 2));

        root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        System.out.println(prob.addOneRow(root, 1, 3));
    }
}
