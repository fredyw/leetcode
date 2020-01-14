package leetcode;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class Problem1315 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, -1, -1);
    }

    private static int sumEvenGrandparent(TreeNode root, int grandparent, int parent) {
        if (root == null) {
            return 0;
        }
        int even = 0;
        if (grandparent % 2 == 0) {
            even = root.val;
        }
        int left = sumEvenGrandparent(root.left, parent, root.val);
        int right = sumEvenGrandparent(root.right, parent, root.val);
        return even + left + right;
    }
}
