package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/complete-binary-tree-inserter/
 */
public class Problem919 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class CBTInserter {
        private final TreeNode root;
        private final LinkedList<TreeNode> queue = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue.add(this.root);
        }

        public int insert(int v) {
            TreeNode current = null;
            while (!queue.isEmpty()) {
                current = queue.remove();
                if (current.left == null) {
                    current.left = new TreeNode(v);
                    queue.add(current.left);
                    if (current.right != null) {
                        queue.add(current.right);
                    } else {
                        queue.addFirst(current);
                    }
                    break;
                } else if (current.right == null) {
                    current.right = new TreeNode(v);
                    queue.add(current.left);
                    queue.add(current.right);
                    break;
                } else {
                    queue.add(current.left);
                    queue.add(current.right);
                }
            }
            return current.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
