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
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem606 prob = new Problem606();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(prob.tree2str(root)); // 1(2(4))(3)

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        System.out.println(prob.tree2str(root)); // 1(2()(4))(3)
    }
}
