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
        if (root == null || (root.left == null && root.right == null && root.val == key)) {
            return null;
        }
        deleteNode(root, null, Direction.MIDDLE, key);
        return root;
    }

    private enum Direction {
        LEFT, RIGHT, MIDDLE
    }

    private static void deleteNode(TreeNode node, TreeNode parent, Direction direction, int key) {
        if (node == null) {
            return;
        }
        if (key == node.val) {
            if (node.left == null && node.right == null) {
                if (direction == Direction.LEFT) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (node.left == null && node.right != null) {
                TreeNode smallest = getSmallest(node.right, node, Direction.RIGHT);
                smallest.left = node.left;
                parent.right = smallest;
            } else {
                TreeNode largest = getLargest(node.left, node, Direction.LEFT);
                parent.left = largest;
                largest.right = node.right;
            }
        } else if (key < node.val) {
            deleteNode(node.left, node, Direction.LEFT, key);
        } else {
            deleteNode(node.right, node, Direction.RIGHT, key);
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

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root = prob.deleteNode(root, 5);

        System.out.println(root);
//        System.out.println(root.left);
//        System.out.println(root.left.left);
//        System.out.println(root.left.left.left);
//        System.out.println(root.left.right);
//        System.out.println(root.right);
//        System.out.println(root.right.right);
    }
}
