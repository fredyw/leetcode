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
        Answer answer = new Answer();
        flipBinaryTree(root, leaf, answer);
        return answer.root;
    }

    private static class Answer {
        private Node root;
    }

    private static void flipBinaryTree(Node root, Node leaf, Answer answer) {
        if (root == null) {
            return;
        }
        if (root.val == leaf.val) {
            answer.root = root;
            root.parent = null;
            return;
        }
        flipBinaryTree(root.left, leaf, answer);
        flipBinaryTree(root.right, leaf, answer);
        if (root.parent != null) {
            root.parent = root.left;
        }
        root.right = root.left;
        root.left = root.parent;
    }
}
