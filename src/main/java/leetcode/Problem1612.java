package leetcode;

import java.util.Arrays;
import java.util.Map;

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
        int[] count1 = new int[26];
        getNodeCount(root1, count1);
        int[] count2 = new int[26];
        getNodeCount(root2, count2);
        return Arrays.equals(count1, count2);
    }

    private void getNodeCount(Node root, int[] count) {
        if (root == null) {
            return;
        }
        if (root.val != '+') {
            count[root.val - 'a']++;
        }
        getNodeCount(root.left, count);
        getNodeCount(root.right, count);
    }
}
