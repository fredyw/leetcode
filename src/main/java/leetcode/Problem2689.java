package leetcode;

// https://leetcode.com/problems/extract-kth-character-from-the-rope-tree/description/
public class Problem2689 {
    public static class RopeTreeNode {
        int len;
        String val;
        RopeTreeNode left;
        RopeTreeNode right;

        RopeTreeNode() {
        }

        RopeTreeNode(String val) {
            this.len = 0;
            this.val = val;
        }

        RopeTreeNode(int len) {
            this.len = len;
            this.val = "";
        }

        RopeTreeNode(int len, RopeTreeNode left, RopeTreeNode right) {
            this.len = len;
            this.val = "";
            this.left = left;
            this.right = right;
        }
    }

    public char getKthCharacter(RopeTreeNode root, int k) {
        StringBuilder sb = new StringBuilder();
        toString(root, sb);
        return sb.charAt(k - 1);
    }

    private static void toString(RopeTreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        if (root.len == 0) {
            sb.append(root.val);
        }
        toString(root.left, sb);
        toString(root.left, sb);
    }
}
