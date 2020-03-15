package leetcode;

import java.util.ArrayList;
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

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        collectNodes(root, nodes);
        return buildTree(nodes, 0, nodes.size() - 1);
    }

    private static TreeNode buildTree(List<TreeNode> nodes, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nodes.get(mid).val);
        node.left = buildTree(nodes, left, mid - 1);
        node.right = buildTree(nodes, mid + 1, right);
        return node;
    }

    private static void collectNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        collectNodes(root.left, nodes);
        nodes.add(root);
        collectNodes(root.right, nodes);
    }
}
