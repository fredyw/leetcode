package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class Problem993 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, DepthParent> map = new HashMap<>();
        traverse(root, x, y, 0, 0, map);
        DepthParent xdp = map.get(x);
        DepthParent ydp = map.get(y);
        if (xdp.parent == ydp.parent) {
            return false;
        }
        return xdp.depth == ydp.depth;
    }

    private static class DepthParent {
        private final int depth;
        private final int parent;

        public DepthParent(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    private static void traverse(TreeNode root, int x, int y, int parent, int depth,
                                 Map<Integer, DepthParent> map) {
        if (root == null) {
            return;
        }
        int newDepth = depth + 1;
        map.put(root.val, new DepthParent(newDepth, parent));
        traverse(root.left, x, y, root.val, newDepth, map);
        traverse(root.right, x, y, root.val, newDepth, map);
    }
}
