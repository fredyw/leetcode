package leetcode;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Problem865 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        NodeDepth nodeDepth = subtreeWithAllDeepest(root, 0);
        if (nodeDepth == null) {
            return null;
        }
        return nodeDepth.node;
    }

    private static class NodeDepth {
        private final TreeNode node;
        private final int depth;

        public NodeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    private static NodeDepth subtreeWithAllDeepest(TreeNode root, int depth) {
        if (root == null) {
            return null;
        }
        NodeDepth left = subtreeWithAllDeepest(root.left, depth + 1);
        NodeDepth right = subtreeWithAllDeepest(root.right, depth + 1);
        if (left == null && right == null) {
            return new NodeDepth(root, depth);
        }
        if (left != null && right != null) {
            if (left.depth == right.depth) {
                return new NodeDepth(root, left.depth);
            }
            if (left.depth > right.depth) {
                return new NodeDepth(left.node, left.depth);
            }
            return new NodeDepth(right.node, right.depth);
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
