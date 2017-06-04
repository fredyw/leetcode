package leetcode;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class Problem606 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);

        String left = tree2str(t.left);
        String right = tree2str(t.right);

        if (left.equals("") && right.equals("")) {
            return sb.toString();
        }
        sb = sb.append("(").append(left).append(")");
        if (!right.equals("")) {
            sb.append("(").append(right).append(")");
        }
        return sb.toString();
    }
}
