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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // For fast lookup.
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        IntRef postOrderIdx = new IntRef(postorder.length - 1);
        return buildTree(postorder, inOrderMap, postOrderIdx, 0, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] postOrder,
                                      Map<Integer, Integer> inOrderMap,
                                      IntRef postOrderIdx,
                                      int startInOrderIdx,
                                      int endInOrderIdx) {
        if (postOrderIdx.val < 0 || startInOrderIdx > endInOrderIdx) {
            postOrderIdx.val++;
            return null;
        }
        int val = postOrder[postOrderIdx.val];
        int inOrderIdx = inOrderMap.get(val);
        TreeNode node = new TreeNode(val);
        postOrderIdx.val--;
        node.right = buildTree(postOrder, inOrderMap, postOrderIdx, inOrderIdx + 1, endInOrderIdx);
        postOrderIdx.val--;
        node.left = buildTree(postOrder, inOrderMap, postOrderIdx, startInOrderIdx, inOrderIdx - 1);
        return node;
    }

    private static class IntRef {
        private int val;

        public IntRef(int val) {
            this.val = val;
        }
    }
}
