package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree/
 */
public class Problem1382 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        collectNodes(root, nodes);
        LinkedList<TreeNode> list = new LinkedList<>();
        int i = 0;
        list.add(nodes.get(i++));
        while (i < nodes.size()) {
            TreeNode current = list.getFirst();
            if (i < nodes.size()) {
                current.left = nodes.get(i++);
                list.add(current.left);
            }
            if (i < nodes.size()) {
                current.right = nodes.get(i++);
                list.add(current.right);
            }
        }
        return nodes.get(0);
    }

    private static void collectNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        nodes.add(root);
        collectNodes(root.left, nodes);
        collectNodes(root.right, nodes);
    }

    public static void main(String[] args) {
        Problem1382 prob = new Problem1382();
    }
}
