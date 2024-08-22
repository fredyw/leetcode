package leetcode;

// https://leetcode.com/problems/check-if-two-expression-trees-are-equivalent/
public class Problem1612 {
    public static class Node {
        char val;
        Node left;
        Node right;

        Node() {
            this.val = ' ';
        }

        Node(char val) {
            this.val = val;
        }

        Node(char val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean checkEquivalence(Node root1, Node root2) {
        // TODO
        return false;
    }
}
