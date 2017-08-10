package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/
 */
public class Problem655 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        // TODO
        return null;
    }

    private static void print(List<List<String>> list) {
        for (List<String> l : list) {
            System.out.println(l);
        }
    }

    public static void main(String[] args) {
        Problem655 prob = new Problem655();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        print(prob.printTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        print(prob.printTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        print(prob.printTree(root));
    }
}
