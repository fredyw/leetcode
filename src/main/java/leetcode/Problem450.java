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

        @Override
        public String toString() {
            return Integer.toString(val);
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
                TreeNode smallest = getSmallest(node.right, node, Direction.RIGHT);
                if (node.left != null) {
                    smallest.left = node.left;
                }
                if (node.right != null) {
                    smallest.right = node.right;
                }
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = smallest;
                    } else {
                        parent.right = smallest;
                    }
                } else {
                    ref.node = smallest;
                }
            } else {
                TreeNode largest = getLargest(node.left, node, Direction.LEFT);
                if (parent != null) {
                    if (direction == Direction.LEFT) {
                        parent.left = largest;
                    } else {
                        parent.right = largest;
                    }
                } else {
                    ref.node = largest;
                }
                if (node.left != null) {
                    largest.left = node.left;
                }
                if (node.right != null) {
                    largest.right = node.right;
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
                parent.left = null;
            } else {
                parent.right = null;
            }
            return node;
        }
        return getSmallest(node.left, node, Direction.LEFT);
    }

    private static TreeNode getLargest(TreeNode node, TreeNode parent, Direction direction) {
        if (node.right == null) {
            if (direction == Direction.LEFT) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            return node;
        }
        return getLargest(node.right, node, Direction.RIGHT);
    }

    public static void main(String[] args) {
        Problem450 prob = new Problem450();

//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);

//        root = prob.deleteNode(root, 3);
//        root = prob.deleteNode(root, 5);
//        root = prob.deleteNode(root, 1);

//        System.out.println(root);
//        System.out.println(root.left);
//        System.out.println(root.left.left);
//        System.out.println(root.left.left.left);
//        System.out.println(root.left.right);
//        System.out.println(root.right);
//        System.out.println(root.right.right);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        root = prob.deleteNode(root, 1);
        System.out.println(root);
        System.out.println(root.left);
        System.out.println(root.right);
    }
}
