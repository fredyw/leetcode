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
        // TODO
        return ' ';
    }
}
