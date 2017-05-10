package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class Problem563 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findTilt(TreeNode root) {
        Tilt tilt = new Tilt();
        findTilt(root, tilt);
        return tilt.value;
    }

    private static class Tilt {
        private int value;
    }

    private static int findTilt(TreeNode node, Tilt tilt) {
        if (node == null) {
            return 0;
        }
        int left = findTilt(node.left, tilt);
        int right = findTilt(node.right, tilt);
        tilt.value += Math.abs(left - right);
        return left + right + node.val;
    }
}
