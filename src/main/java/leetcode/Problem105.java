package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Problem105 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode node = new TreeNode(preorder[0]);
        buildTree(node, preorder, new IntRef(0), 0, inorder.length, inOrderMap);
        return node;
    }

    private class IntRef {
        private int idx;

        public IntRef(int idx) {
            this.idx = idx;
        }
    }

    private void buildTree(TreeNode node,
                           int[] preorder,
                           IntRef preOrderIndexRef,
                           int fromInOrderIdx,
                           int toInOrderIdx,
                           Map<Integer, Integer> inOrderMap) {
        if (preOrderIndexRef.idx >= preorder.length) {
            return;
        }
        int inOrderIdx = inOrderMap.get(preorder[preOrderIndexRef.idx]);
        if (fromInOrderIdx < inOrderIdx) {
            preOrderIndexRef.idx++;
            int val = preorder[preOrderIndexRef.idx];
            node.left = new TreeNode(val);
            buildTree(node.left, preorder, preOrderIndexRef, fromInOrderIdx, inOrderIdx, inOrderMap);
        }
        if (inOrderIdx + 1 < toInOrderIdx) {
            preOrderIndexRef.idx++;
            int val = preorder[preOrderIndexRef.idx];
            node.right = new TreeNode(val);
            buildTree(node.right, preorder, preOrderIndexRef, inOrderIdx + 1, toInOrderIdx, inOrderMap);
        }
    }
}
