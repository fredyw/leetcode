package leetcode;

/**
 * https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/
 */
public class Problem671 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int findSecondMinimumValue(TreeNode root) {
        FirstSecondMinimum fsm = new FirstSecondMinimum();
        findSecondMinimumValue(root, fsm);
        return (fsm.secondMin == null || fsm.firstMin == fsm.secondMin) ? -1 : fsm.secondMin;
    }

    private static class FirstSecondMinimum {
        private Integer firstMin;
        private Integer secondMin;
    }

    private static void findSecondMinimumValue(TreeNode node, FirstSecondMinimum fsm) {
        if (node == null) {
            return;
        }
        if (fsm.firstMin == null) {
            fsm.firstMin = node.val;
        } else if (fsm.secondMin == null) {
            fsm.secondMin = node.val;
        } else {
            if (fsm.firstMin < node.val) {
                fsm.secondMin = fsm.firstMin;
                fsm.firstMin = node.val;
            } else if (fsm.secondMin < node.val) {
                fsm.secondMin = fsm.secondMin;
            }
        }
        findSecondMinimumValue(node.left, fsm);
        findSecondMinimumValue(node.right, fsm);
    }

    public static void main(String[] args) {
        Problem671 prob = new Problem671();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(prob.findSecondMinimumValue(root)); // 5

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        System.out.println(prob.findSecondMinimumValue(root)); // -1

        root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(8);
        root.right.right.right = new TreeNode(8);
        System.out.println(prob.findSecondMinimumValue(root)); // 5
    }
}
