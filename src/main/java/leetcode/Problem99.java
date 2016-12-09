package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 */
public class Problem99 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Ref {
        private TreeNode node;
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> swappedNodes = new ArrayList<>();
        Ref ref = new Ref();
        recoverTree(root, ref, swappedNodes);
        swap(swappedNodes.get(0), swappedNodes.get(1));
    }

    public void recoverTree(TreeNode root, Ref ref, List<TreeNode> swappedNodes) {
        if (root == null) {
            return;
        }
        recoverTree(root.left, ref, swappedNodes);
        if (ref.node != null && ref.node.val > root.val) {
            if (swappedNodes.size() == 0) {
                swappedNodes.add(ref.node);
                swappedNodes.add(root);
            } else {
                swappedNodes.remove(1);
                swappedNodes.add(root);
            }
        }
        ref.node = root;
        recoverTree(root.right, ref, swappedNodes);
    }

    private static void swap(TreeNode node1, TreeNode node2) {
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
