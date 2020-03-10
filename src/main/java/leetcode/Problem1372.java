package leetcode;

/**
 * https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
 */
public class Problem1372 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int longestZigZag(TreeNode root) {
        IntRef answer = new IntRef();
        longestZigZag(root, answer);
        return answer.val;
    }

    private static void longestZigZag(TreeNode root, IntRef ref) {
        if (root == null) {
            return;
        }
        longestZigZag(root.left, ref);
        longestZigZag(root.right, ref);
        ref.val = Math.max(ref.val, Math.max(
            longestZigZag(root, Direction.LEFT),
            longestZigZag(root, Direction.RIGHT)) - 1);
    }

    private static class IntRef {
        private int val;
    }

    private enum Direction {
        LEFT, RIGHT
    }

    private static int longestZigZag(TreeNode root, Direction direction) {
        if (root == null) {
            return 0;
        }
        if (direction == Direction.LEFT) {
            return longestZigZag(root.left, Direction.RIGHT) + 1;
        }
        return longestZigZag(root.right, Direction.LEFT) + 1;
    }

    public static void main(String[] args) {
        Problem1372 prob = new Problem1372();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);
        System.out.println(prob.longestZigZag(root)); // 3
    }
}
