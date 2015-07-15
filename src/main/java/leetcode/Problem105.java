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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode node = new TreeNode(preorder[0]);
        PreOrder po = new PreOrder();
        buildTree(node, preorder, inorder, po, 0, inorder.length, map, Direction.CENTER);
        return node;
    }

    private class PreOrder {
        int idx;
    }
    
    private enum Direction {
        LEFT, RIGHT, CENTER
    }
    
    private void buildTree(TreeNode node, int[] preorder, int[] inorder,
        PreOrder po, int fromInOrderIdx, int toInOrderIdx, Map<Integer, Integer> map,
        Direction direction) {
        if (po.idx >= preorder.length) {
            return;
        }
        int inOrderIdx = map.get(preorder[po.idx]);
        TreeNode newNode = null;
        if (direction == Direction.LEFT) {
            node.left = new TreeNode(preorder[po.idx]);
            newNode = node.left;
        } else if (direction == Direction.RIGHT) {
            node.right = new TreeNode(preorder[po.idx]);
            newNode = node.right;
        } else {
            newNode = node;
        }
        if (fromInOrderIdx < inOrderIdx) {
            po.idx++;
            buildTree(newNode, preorder, inorder, po, fromInOrderIdx,
                inOrderIdx, map, Direction.LEFT);
        }
        if (inOrderIdx+1 < toInOrderIdx) {
            po.idx++;
            buildTree(newNode, preorder, inorder, po, inOrderIdx+1, toInOrderIdx,
                map, Direction.RIGHT);
        }
    }
}
