package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 */
public class Problem538 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        List<Integer> list = new ArrayList<>();
        sortedList(root, list);
        int sum = 0;
        int[] sums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            if (i == 0) {
                sums[i] = 0;
            } else {
                sums[i] = sums[i - 1] + list.get(i - 1);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                map.put(list.get(i), sum);
            } else {
                map.put(list.get(i), sum - sums[i]);
            }
        }
        return convert(root, map);
    }

    private static TreeNode convert(TreeNode node, Map<Integer, Integer> map) {
        TreeNode left = null;
        TreeNode right = null;
        if (node.left == null && node.right == null) {
            return new TreeNode(map.get(node.val));
        }
        if (node.left != null) {
            left = convert(node.left, map);
        }
        if (node.right != null) {
            right = convert(node.right, map);
        }
        TreeNode parent = new TreeNode(map.get(node.val));
        parent.left = left;
        parent.right = right;
        return parent;
    }

    private static void sortedList(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        sortedList(node.left, list);
        list.add(node.val);
        sortedList(node.right, list);
    }
}
