package leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/description/
public class Problem1676 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        LCA lca = new LCA();
        lowestCommonAncestor(root, Arrays.stream(nodes)
                .map(node -> node.val)
                .collect(Collectors.toSet()),
            lca);
        return lca.node;
    }

    private static class LCA {
        private TreeNode node;
    }

    private static boolean lowestCommonAncestor(TreeNode root, Set<Integer> nodes, LCA lca) {
        if (root == null) {
            return false;
        }
        var parent = nodes.contains(root.val);
        var left = lowestCommonAncestor(root.left, nodes, lca);
        var right = lowestCommonAncestor(root.right, nodes, lca);
        if (parent || (left && right)) {
            lca.node = root;
            return true;
        }
        return left || right;
    }
}
