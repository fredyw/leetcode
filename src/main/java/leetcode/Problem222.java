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
        boolean done;
    }

    public int countNodes(TreeNode root) {
        int maxLevel = getNumLevel(root, 0);
//        System.out.println("maxlevel=" + maxLevel);
        Count incomplete = new Count();
        countIncomplete(root, maxLevel, 0, incomplete);
//        System.out.println("countIncomplete=" + countIncomplete);
        return (int) (Math.pow(2, maxLevel) - 1) - incomplete.count;
    }

    private void countIncomplete(TreeNode node, int maxLevel, int level, Count count) {
        if (node == null) {
            if (maxLevel > level) {
                count.count++;
                return;
            }
            count.done = true;
            return;
        }
        countIncomplete(node.right, maxLevel, level + 1, count);
        if (count.done) {
            return;
        }
        countIncomplete(node.left, maxLevel, level + 1, count);
        if (count.done) {
            return;
        }
    }

    private int getNumLevel(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        return getNumLevel(node.left, level + 1);
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
