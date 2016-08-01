package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 */
public class Problem95 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        if (n == 0) {
            result.add(null);
        }
        Set<String> treeNodes = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            List<Integer> numbers = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                numbers.add(j);
            }
            generate(numbers, root, treeNodes, result);
        }
        return result;
    }

    private void generate(List<Integer> numbers, TreeNode root, Set<String> treeNodes,
                          List<TreeNode> result) {
        if (numbers.size() == 0) {
            String str = toString(root);
            if (!treeNodes.contains(str)) {
                result.add(root);
            }
            treeNodes.add(str);
            return;
        }
        for (int i = 0; i < numbers.size(); i++) {
            int val = numbers.get(i);
            TreeNode c = copy(root);
            TreeNode r = add(c, val);
            List<Integer> newNumbers = new ArrayList<>();
            for (int j = 0; j < numbers.size(); j++) {
                if (i == j) {
                    continue;
                }
                newNumbers.add(numbers.get(j));
            }
            generate(newNumbers, r, treeNodes, result);
        }
    }

    private TreeNode copy(TreeNode node) {
        TreeNode cp = new TreeNode(node.val);
        copy(node, cp);
        return cp;
    }

    private void copy(TreeNode src, TreeNode dest) {
        if (src == null) {
            return;
        }
        if (src.left != null) {
            TreeNode newNode = new TreeNode(src.left.val);
            dest.left = newNode;
            copy(src.left, newNode);
        }
        if (src.right != null) {
            TreeNode newNode = new TreeNode(src.right.val);
            dest.right = newNode;
            copy(src.right, newNode);
        }
    }

    private TreeNode add(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val > val) { // left
            node.left = add(node.left, val);
        } else { // right
            node.right = add(node.right, val);
        }
        return node;
    }

    private String toString(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode n = queue.remove();
            sb.append(n.val + ",");
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
        return sb.toString();
    }
}
