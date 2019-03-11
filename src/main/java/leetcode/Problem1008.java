package leetcode;

/**
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class Problem1008 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, new IntRef(), Integer.MAX_VALUE);
    }

    private static TreeNode bstFromPreorder(int[] preOrder, IntRef index, int max) {
        if (index.val == preOrder.length) {
            return null;
        }
        int val = preOrder[index.val];
        if (val > max) {
            return null;
        }
        index.val++;
        TreeNode node = new TreeNode(val);
        node.left = bstFromPreorder(preOrder, index, val);
        node.right = bstFromPreorder(preOrder, index, max);
        return node;
    }

    private static class IntRef {
        private int val;
    }
}
