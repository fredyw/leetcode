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
        } else if (fsm.secondMin == null && fsm.firstMin != node.val) {
            fsm.secondMin = node.val;
        } else {
            if (fsm.firstMin != null && fsm.secondMin != null) {
                if (fsm.firstMin > node.val) {
                    fsm.secondMin = fsm.firstMin;
                    fsm.firstMin = node.val;
                } else if (fsm.secondMin > node.val && fsm.firstMin != node.val) {
                    fsm.secondMin = node.val;
                }
            }
        }
        findSecondMinimumValue(node.left, fsm);
        findSecondMinimumValue(node.right, fsm);
    }
}
