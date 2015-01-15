package leetcode;

/**
 * https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class Problem109 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        // TODO: to be implemented
        return null;
    }
    
    public static void main(String[] args) {
        Problem109 prob = new Problem109();
    }
}
