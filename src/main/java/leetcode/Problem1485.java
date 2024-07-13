package leetcode;

// https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
public class Problem1485 {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public static class NodeCopy {
        int val;
        Node left;
        Node right;
        Node random;

        NodeCopy() {
        }

        NodeCopy(int val) {
            this.val = val;
        }

        NodeCopy(int val, Node left, Node right, Node random) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.random = random;
        }
    }

    public NodeCopy copyRandomBinaryTree(Node root) {
        // TODO
        return null;
    }
}
