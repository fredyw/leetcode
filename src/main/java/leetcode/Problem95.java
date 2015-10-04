package leetcode;

import java.util.ArrayList;
import java.util.List;

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

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            TreeNode root = new TreeNode(i);
            List<Integer> numbers = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }
                numbers.add(j);
            }
            generate(numbers, root, result);
        }
        return result;
    }

    private void generate(List<Integer> numbers, TreeNode root, List<TreeNode> result) {
        if (numbers.size() == 0) {
            System.out.println("hey");
            result.add(root);
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
            generate(newNumbers, r, result);
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

    public static void main(String[] args) {
        Problem95 prob = new Problem95();
        List<TreeNode> result = prob.generateTrees(3);
        for (TreeNode node : result) {
            System.out.println(node);
        }
//        TreeNode root = prob.add(null, 1);
//        root = prob.add(root, 3);
//        root = prob.add(root, 2);
//
//        System.out.println(root);
//        System.out.println(root.right);
//        System.out.println(root.right.left);
//
//        TreeNode copy = prob.copy(root);
//
//        System.out.println(copy);
//        System.out.println(copy.right);
//        System.out.println(copy.right.left);
    }
}
