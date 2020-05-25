package leetcode;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 */
public class Problem1457 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        IntRef answer = new IntRef();
        pseudoPalindromicPaths(root, new int[9], answer);
        return answer.val;
    }

    private static class IntRef {
        private int val;
    }

    private static void pseudoPalindromicPaths(TreeNode root, int[] counts, IntRef answer) {
        if (root == null) {
            return;
        }
        counts[root.val - 1]++;
        if (root.left == null && root.right == null) {
            int odd = 0;
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] % 2 != 0) {
                    odd++;
                }
            }
            if (odd <= 1) {
                answer.val++;
            }
        } else {
            pseudoPalindromicPaths(root.left, counts, answer);
            pseudoPalindromicPaths(root.right, counts, answer);
        }
        counts[root.val - 1]--;
    }
}
