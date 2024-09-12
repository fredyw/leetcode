package leetcode;

// https://leetcode.com/problems/inorder-successor-in-bst-ii/description/
public class Problem510 {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        Node root = findRoot(node);
        var answer = new Ref<Node>();
        inOrderSuccessor(root, node.val, answer);
        return answer.val;
    }

    private static Node findRoot(Node node) {
        Node n = node;
        while (n.parent != null) {
            n = n.parent;
        }
        return n;
    }

    private static class Ref<T> {
        private T val;
    }

    private static void inOrderSuccessor(Node root, int node, Ref<Node> answer) {
        if (root == null) {
            return;
        }
        inOrderSuccessor(root.left, node, answer);
        if (root.val > node) {
            if (answer.val == null) {
                answer.val = root;
            }
            return;
        }
        inOrderSuccessor(root.right, node, answer);
    }
}
