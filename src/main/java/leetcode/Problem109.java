package leetcode;

import java.util.ArrayList;
import java.util.List;

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

    private TreeNode root;

    public TreeNode sortedListToBST(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        for (ListNode n = head; n != null; n = n.next) {
            listNodes.add(n);
        }
        sortedListToBST(listNodes, 0, listNodes.size());
        return root;
    }

    private void sortedListToBST(List<ListNode> listNodes, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (int) Math.ceil((hi + lo) / 2);
        int val = listNodes.get(mid).val;
        if (root == null) {
            root = new TreeNode(val);
        } else {
            add(root, val);
        }
        sortedListToBST(listNodes, lo, mid);
        sortedListToBST(listNodes, mid + 1, hi);
    }

    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val <= node.val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }
}
