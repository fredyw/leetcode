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
        // For fast lookup.
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inOrderMap, new IntRef(), 0, preorder.length - 1);
    }

    private static TreeNode buildTree(int[] preOrder,
                                      Map<Integer, Integer> inOrderMap,
                                      IntRef preOrderIdx,
                                      int startInOrderIdx,
                                      int endInOrderIdx) {
        if (preOrder.length <= preOrderIdx.val || startInOrderIdx > endInOrderIdx) {
            preOrderIdx.val--;
            return null;
        }
        int val = preOrder[preOrderIdx.val];
        int inOrderIdx = inOrderMap.get(val);
        TreeNode node = new TreeNode(val);
        preOrderIdx.val++;
        node.left = buildTree(preOrder, inOrderMap, preOrderIdx, startInOrderIdx, inOrderIdx - 1);
        preOrderIdx.val++;
        node.right = buildTree(preOrder, inOrderMap, preOrderIdx, inOrderIdx + 1, endInOrderIdx);
        return node;
    }

    private static class IntRef {
        private int val;
    }
}
