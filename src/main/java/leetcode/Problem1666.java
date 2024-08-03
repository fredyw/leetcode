package leetcode;

// https://leetcode.com/problems/change-the-root-of-a-binary-tree/
public class Problem1666 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node flipBinaryTree(Node root, Node leaf) {
        return flipBinaryTree(root, leaf, null);
    }

    private static Node flipBinaryTree(Node root, Node node, Node newParent) {
        Node oldParent = node.parent;
        node.parent = newParent;
        if (node.left == newParent) {
            node.left = null;
        }
        if (node.right == newParent) {
            node.right = null;
        }
        if (node == root) {
            return node;
        }
        if (node.left != null) {
            node.right = node.left;
        }
        node.left = flipBinaryTree(root, oldParent, node);
        return node;
    }
}
