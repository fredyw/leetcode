package leetcode;

// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
public class Problem426 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Wrapper wrapper = new Wrapper();
        treeToDoubleList(root, wrapper);
        wrapper.current.right = wrapper.root;
        wrapper.root.left = wrapper.current;
        return wrapper.root;
    }

    private static class Wrapper {
        private Node root;
        private Node current;
    }

    private static void treeToDoubleList(Node root, Wrapper wrapper) {
        if (root == null) {
            return;
        }
        treeToDoubleList(root.left, wrapper);
        if (wrapper.root == null) {
            wrapper.root = root;
        } else {
            wrapper.current.right = root;
            root.left = wrapper.current;
        }
        wrapper.current = root;
        treeToDoubleList(root.right, wrapper);
    }
}
