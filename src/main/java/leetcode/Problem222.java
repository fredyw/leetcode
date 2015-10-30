package leetcode;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class Problem222 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Count {
        int count;
        int level;
        boolean done;
    }

    public int countNodes(TreeNode root) {
        Count count = new Count();
        countIncomplete(root, 0, count);
        int maxLevel = count.level + 1;
//        System.out.println("countIncomplete=" + count.count);
        return (int) (Math.pow(2, maxLevel) - 1) - count.count;
    }

    private void countIncomplete(TreeNode node, int level, Count count) {
        if (node == null) {
            if (count.level == 0) {
                count.count++;
                count.level = level;
                return;
            } else if (count.level == level) {
                count.count++;
                return;
            }
            count.done = true;
            return;
        }
        countIncomplete(node.right, level + 1, count);
        if (count.done) {
            return;
        }
        countIncomplete(node.left, level + 1, count);
        if (count.done) {
            return;
        }
    }

    public static void main(String[] args) {
        Problem222 prob = new Problem222();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.left.left = new TreeNode(11);
        root.right.right = new TreeNode(12);

        System.out.println(prob.countNodes(root));
    }
}
