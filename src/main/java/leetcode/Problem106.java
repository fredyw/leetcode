package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Problem106 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class IntRef {
        private int idx;

        public IntRef(int idx) {
            this.idx = idx;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode node = new TreeNode(postorder[postorder.length - 1]);
        buildTree(node, postorder, new IntRef(postorder.length - 1), 0, inorder.length, inOrderMap);
        return node;
    }

    private void buildTree(TreeNode node,
                           int[] postorder,
                           IntRef postOrderIndexRef,
                           int fromInOrderIdx,
                           int toInOrderIdx,
                           Map<Integer, Integer> inOrderMap) {
        int inOrderIdx = inOrderMap.get(postorder[postOrderIndexRef.idx]);
        if (inOrderIdx + 1 < toInOrderIdx) {
            postOrderIndexRef.idx--;
            int val = postorder[postOrderIndexRef.idx];
            node.right = new TreeNode(val);
            buildTree(node.right, postorder, postOrderIndexRef, inOrderIdx + 1, toInOrderIdx, inOrderMap);
        }
        if (fromInOrderIdx < inOrderIdx) {
            postOrderIndexRef.idx--;
            int val = postorder[postOrderIndexRef.idx];
            node.left = new TreeNode(val);
            buildTree(node.left, postorder, postOrderIndexRef, fromInOrderIdx, inOrderIdx, inOrderMap);
        }
    }
}
