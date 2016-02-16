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
        if (root == null) {
            return result;
        }
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if ((node.left == null || set.contains(node.left))
                && (node.right == null || set.contains(node.right))) {
                set.add(node);
                result.add(node.val);
                continue;
            }
            stack.add(node);
            if (node.left == null || set.contains(node.left)) {
                if (node.right != null) {
                    stack.add(node.right);
                    continue;
                }
            }
            TreeNode n = node.left;
            while (n != null) {
                stack.add(n);
                n = n.left;
            }
        }
        return result;
    }
}
