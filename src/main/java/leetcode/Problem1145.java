package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 */
public class Problem1145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1145 prob = new Problem1145();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        System.out.println(prob.btreeGameWinningMove(root, 11, 3)); // true
        System.out.println(prob.btreeGameWinningMove(root, 11, 2)); // false
    }
}
