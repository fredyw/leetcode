package leetcode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Problem617 {
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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem617 prob = new Problem617();

        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);

        prob.mergeTrees(t1, t2);
    }
}
