package leetcode;

/**
 * https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Problem108 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    private TreeNode root;
    
    public TreeNode sortedArrayToBST(int[] num) {
        sortedArrayToBST(num, 0, num.length);
        return root;
    }
    
    private void sortedArrayToBST(int[] num, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (int) Math.ceil((hi + lo) / 2);
        int val = num[mid];
        if (root == null) {
            root = new TreeNode(val);
        } else {
            add(root, val);
        }
        sortedArrayToBST(num, lo, mid);
        sortedArrayToBST(num, mid+1, hi);
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
