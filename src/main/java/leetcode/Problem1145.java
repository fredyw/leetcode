package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        System.out.println(Arrays.toString(counts));
        List<Integer> adjacents = new ArrayList<>();
        getAdjacents(null, root, x, adjacents);
        System.out.println(adjacents);
        return false;
    }

    private static void getAdjacents(TreeNode parent, TreeNode current,
                                     int x, List<Integer> adjacents) {
        if (current == null) {
            return;
        }
        if (current.val == x) {
            if (parent != null) {
                adjacents.add(parent.val);
            }
            if (current.left != null) {
                adjacents.add(current.left.val);
            }
            if (current.right != null) {
                adjacents.add(current.right.val);
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

    public static void main(String[] args) {
        Problem1145 prob = new Problem1145();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        System.out.println(prob.btreeGameWinningMove(root, 11, 3)); // true
//        System.out.println(prob.btreeGameWinningMove(root, 11, 2)); // false
//        System.out.println(prob.btreeGameWinningMove(root, 11, 1)); // true
    }
}
