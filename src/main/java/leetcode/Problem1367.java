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
        answer |= subPath(head, root.left);
        answer |= subPath(head, root.right);
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

    public static void main(String[] args) {
        Problem1367 prob = new Problem1367();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(6);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(3);

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        System.out.println(prob.isSubPath(head, root)); // true
    }
}
