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
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1028 prob = new Problem1028();
        System.out.println(prob.recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println(prob.recoverFromPreorder("1-2--3---4-5--6---7"));
        System.out.println(prob.recoverFromPreorder("1-401--349---90--88"));
    }
}
