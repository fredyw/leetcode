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

    private class PostOrder {
        int idx;

        public PostOrder(int idx) {
            this.idx = idx;
        }
    }

    private enum Direction {
        LEFT, RIGHT, CENTER
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node = new TreeNode(postorder[postorder.length-1]);
        PostOrder po = new PostOrder(postorder.length-1);
        buildTree(node, inorder, postorder, po, 0, inorder.length, map, Direction.CENTER);
        return node;
    }

    private void buildTree(TreeNode node, int[] inorder, int[] postorder,
                           PostOrder po, int fromInOrderIdx, int toInOrderIdx,
                           Map<Integer, Integer> map, Direction direction) {
        if (po.idx < 0) {
            return;
        }
        int inOrderIdx = map.get(postorder[po.idx]);
        TreeNode newNode = null;
        if (direction == Direction.LEFT) {
            node.left = new TreeNode(postorder[po.idx]);
            newNode = node.left;
        } else if (direction == Direction.RIGHT) {
            node.right = new TreeNode(postorder[po.idx]);
            newNode = node.right;
        } else {
            newNode = node;
        }
        if (inOrderIdx+1 < toInOrderIdx) {
            po.idx--;
            buildTree(newNode, inorder, postorder, po, inOrderIdx+1, toInOrderIdx,
                map, Direction.RIGHT);
        }
        if (fromInOrderIdx < inOrderIdx) {
            po.idx--;
            buildTree(newNode, inorder, postorder, po, fromInOrderIdx,
                inOrderIdx, map, Direction.LEFT);
        }
    }
}
