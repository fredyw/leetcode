package leetcode;

import java.util.ArrayList;
import java.util.List;

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
        return null;
    }

    private static void postOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
    
    private static void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
    
    public static void main(String[] args) {
        Problem106 prob = new Problem106();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        
        List<Integer> inOrderList = new ArrayList<>();
        inOrder(root, inOrderList);
        int[] inOrder = new int[inOrderList.size()];
        for (int i = 0; i < inOrderList.size(); i++) {
            inOrder[i] = inOrderList.get(i);
        }
        System.out.println("In-order  : " + inOrderList);
        
        List<Integer> postOrderList = new ArrayList<>();
        postOrder(root, postOrderList);
        int[] postOrder = new int[postOrderList.size()];
        for (int i = 0; i < postOrderList.size(); i++) {
            postOrder[i] = postOrderList.get(i);
        }
        System.out.println("Post-order: " + postOrderList);
        
        TreeNode newTree = prob.buildTree(inOrder, postOrder);
    }
}
