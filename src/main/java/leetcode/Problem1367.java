package leetcode;

/**
 * https://leetcode.com/problems/linked-list-in-binary-tree/
 */
public class Problem1367 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean answer = false;
        if (head.val == root.val) {
            answer |= subPath(head, root);
        }
        answer |= isSubPath(head, root.left);
        answer |= isSubPath(head, root.right);
        return answer;
    }

    private static boolean subPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null || head.val != root.val) {
            return false;
        }
        return subPath(head.next, root.left) || subPath(head.next, root.right);
    }
}
