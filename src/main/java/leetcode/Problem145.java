package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 */
public class Problem145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        boolean right = false;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            while (node.left == null) {
                TreeNode n = node.left;
                stack.add(n);
            }
            
            System.out.println("popping: " + node.val);
            while ((node.left == null || set.contains(node.left))
                && (node.right == null || set.contains(node.right))) {
                System.out.println(node.val);
                result.add(node.val);
                set.add(node);
            }
            if (node.left != null) {
                System.out.println("adding: " + node.left.val);
                stack.add(node.left);
                right = false;
            } else {
                right = true;
                if (right) {
                    if (node.right != null) {
                        System.out.println("adding: " + node.right.val);
                        stack.add(node.right);
                    }
                }
            }
        }
        return result;
    }

    private List<Integer> recursivePostOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursivePostOrderTraversal(root, result);
        return result;
    }

    private void recursivePostOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        recursivePostOrderTraversal(root.left, result);
        recursivePostOrderTraversal(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        Problem145 prob = new Problem145();
//        System.out.println(prob.recursivePostOrderTraversal(root));
        System.out.println(prob.postorderTraversal(root));
    }
}
