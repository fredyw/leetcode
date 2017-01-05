package leetcode;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class Problem450 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        NodeRef ref = new NodeRef(root);
        deleteNode(root, null, Direction.MIDDLE, key, ref);
        return ref.node;
    }

    private enum Direction {
        LEFT, RIGHT, MIDDLE
    }

    private static class NodeRef {
        private TreeNode node;

        public NodeRef(TreeNode node) {
            this.node = node;
        }
    }

    private static void deleteNode(TreeNode node, TreeNode parent, Direction direction, int key, NodeRef ref) {
        if (node == null) {
            return;
        }
        if (key == node.val) {
            if (node.left == null && node.right == null) {
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else {
                    ref.node = null;
                }
            } else if (node.left == null && node.right != null) {
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = node.right;
                    } else {
                        parent.right = node.right;
                    }
                } else {
                    ref.node = node.right;
                }
            } else if (node.left != null && node.right == null) {
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = node.left;
                    } else {
                        parent.right = node.left;
                    }
                } else {
                    ref.node = node.left;
                }
            } else {
                TreeNode smallest = getSmallest(node.right, node, Direction.RIGHT);
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = smallest;
                    } else {
                        parent.right = smallest;
                    }
                } else {
                    ref.node = smallest;
                }
                if (node.left != null) {
                    smallest.left = node.left;
                }
                if (node.right != null) {
                    smallest.right = node.right;
                }
            }
        } else if (key < node.val) {
            deleteNode(node.left, node, Direction.LEFT, key, ref);
        } else {
            deleteNode(node.right, node, Direction.RIGHT, key, ref);
        }
    }

    private static TreeNode getSmallest(TreeNode node, TreeNode parent, Direction direction) {
        if (node.left == null) {
            if (direction == Direction.LEFT) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
            return node;
        }
        return getSmallest(node.left, node, Direction.LEFT);
    }
}
