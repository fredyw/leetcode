package leetcode;

import java.util.ArrayList;
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
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int rowSize = height(root);
        int colSize = (int) Math.pow(2, rowSize) - 1;
        for (int i = 0; i < rowSize; i++) {
            List<String> newList = new ArrayList<>();
            for (int j = 0; j < colSize; j++) {
                newList.add("");
            }
            result.add(newList);
        }
        printTree(root, 0, 0, colSize - 1, result);
        return result;
    }

    private static void printTree(TreeNode node, int row, int colLeft, int colRight, List<List<String>> result) {
        if (node == null) {
            return;
        }
        int mid = (colLeft + colRight) / 2;
        result.get(row).set(mid, Integer.toString(node.val));
        printTree(node.left, row + 1, colLeft, mid - 1, result);
        printTree(node.right, row + 1, mid + 1, colRight, result);
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static void print(List<List<String>> list) {
        for (List<String> l : list) {
            System.out.println(l);
        }
    }
}
