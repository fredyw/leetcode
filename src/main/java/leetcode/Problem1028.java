package leetcode;

/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class Problem1028 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode recoverFromPreorder(String S) {
        return recoverFromPreorder(S, new IntRef(), 0);
    }

    private static class IntRef {
        private int val;
    }

    private static TreeNode recoverFromPreorder(String s, IntRef idx, int depth) {
        if (idx.val == s.length()) {
            return null;
        }
        int i = idx.val;
        int count = 0;
        while (i < s.length() && s.charAt(i) == '-') {
            count++;
            i++;
        }
        String num = "";
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            num += s.charAt(i);
            i++;
        }
        TreeNode node = null;
        if (count == depth) {
            node = new TreeNode(Integer.parseInt(num));
            idx.val = i;
            node.left = recoverFromPreorder(s, idx, depth + 1);
            node.right = recoverFromPreorder(s, idx, depth + 1);
        }
        return node;
    }
}
