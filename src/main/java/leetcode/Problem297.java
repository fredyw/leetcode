package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Problem297 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }

    public static class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node == null) {
                    result.append("null,");
                    continue;
                } else {
                    result.append(node.val + ",");
                }
                if (node.left != null) {
                    queue.add(node.left);
                } else {
                    queue.add(null);
                }
                if (node.right != null) {
                    queue.add(node.right);
                } else {
                    queue.add(node.right);
                }
            }
            return result.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            int i = 0;
            if (nodes[i].equals("null")) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
            LinkedList<TreeNode> parents = new LinkedList<>();
            parents.add(root);
            i++;
            out:
            while (!parents.isEmpty()) {
                LinkedList<TreeNode> newParents = new LinkedList<>();
                for (TreeNode parent : parents) {
                    if (i >= nodes.length) {
                        break out;
                    }
                    // left
                    if (!nodes[i].equals("null")) {
                        int val = Integer.parseInt(nodes[i]);
                        TreeNode node = new TreeNode(val);
                        parent.left = node;
                        newParents.add(node);
                    }
                    i++;
                    if (i >= nodes.length) {
                        break out;
                    }
                    // right
                    if (!nodes[i].equals("null")) {
                        int val = Integer.parseInt(nodes[i]);
                        TreeNode node = new TreeNode(val);
                        parent.right = node;
                        newParents.add(node);
                    }
                    i++;
                }
                parents = newParents;
            }
            return root;
        }
    }
}
