package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/binary-tree-coloring-game/
 */
public class Problem1145 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        int[] counts = new int[n + 1];
        getChildCount(root, counts);
        Map<Type, Integer> adjacents = new HashMap<>();
        getAdjacents(null, root, x, adjacents);
        if (adjacents.get(Type.PARENT) != null) {
            int player1 = counts[x];
            int player2 = n - counts[x];
            if (player1 < player2) {
                return true;
            }
        }
        if (adjacents.get(Type.LEFT_CHILD) != null) {
            int player1 = n - counts[adjacents.get(Type.LEFT_CHILD)];
            int player2 = counts[adjacents.get(Type.LEFT_CHILD)];
            if (player1 < player2) {
                return true;
            }
        }
        if (adjacents.get(Type.RIGHT_CHILD) != null) {
            int player1 = n - counts[adjacents.get(Type.RIGHT_CHILD)];
            int player2 = counts[adjacents.get(Type.RIGHT_CHILD)];
            if (player1 < player2) {
                return true;
            }
        }
        return false;
    }

    private enum Type {
        PARENT, LEFT_CHILD, RIGHT_CHILD
    }

    private static void getAdjacents(TreeNode parent, TreeNode current,
                                     int x, Map<Type, Integer> adjacents) {
        if (current == null) {
            return;
        }
        if (current.val == x) {
            if (parent != null) {
                adjacents.put(Type.PARENT, parent.val);
            }
            if (current.left != null) {
                adjacents.put(Type.LEFT_CHILD, current.left.val);
            }
            if (current.right != null) {
                adjacents.put(Type.RIGHT_CHILD, current.right.val);
            }
            return;
        }
        getAdjacents(current, current.left, x, adjacents);
        getAdjacents(current, current.right, x, adjacents);
    }

    private static int getChildCount(TreeNode root, int[] counts) {
        if (root == null) {
            return 0;
        }
        int count = getChildCount(root.left, counts) + getChildCount(root.right, counts) + 1;
        counts[root.val] = count;
        return count;
    }
}
