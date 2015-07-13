package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        buildTree(null, preorder, inorder, 0, 0, inorder.length, map);
        return null;
    }
    
    private void buildTree(TreeNode node, int[] preorder, int[] inorder,
        int preOrderIdx, int fromInOrderIdx, int toInOrderIdx, Map<Integer, Integer> map) {
        int inOrderIdx = map.get(preorder[preOrderIdx]);
        if (inOrderIdx > 0) {
            toInOrderIdx = inOrderIdx;
            System.out.print("Left: ");
            for (int i = fromInOrderIdx; i < toInOrderIdx; i++) {
                System.out.print(inorder[i] + " ");
            }
            System.out.println();
            buildTree(null, preorder, inorder, preOrderIdx+1, fromInOrderIdx,
                toInOrderIdx, map);
        }
        if (inorder.length-inOrderIdx > 0) {
            System.out.print("Right: ");
            fromInOrderIdx = inOrderIdx;
            for (int i = fromInOrderIdx; i < toInOrderIdx; i++) {
                System.out.print(inorder[i] + " ");
            }
            System.out.println();
            buildTree(null, preorder, inorder, preOrderIdx+1, fromInOrderIdx, toInOrderIdx,
                map);
        }
    }
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
    
    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public static void main(String[] args) {
        Problem105 prob = new Problem105();
        
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println("Pre-order:");
        prob.preOrder(root);
        System.out.println();
        System.out.println("In-order:");
        prob.inOrder(root);
        System.out.println();
        
        prob.buildTree(
            new int[]{3, 5, 6, 2, 7, 4, 1, 0, 8},
            new int[]{6, 5, 7, 2, 4, 3, 0, 1, 8});
    }
}
