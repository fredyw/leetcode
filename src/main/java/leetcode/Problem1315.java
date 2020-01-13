package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
 */
public class Problem1315 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        return sumEvenGrandparent(root, new ArrayList<>());
    }

    private static int sumEvenGrandparent(TreeNode root, List<Integer> grandparents) {
        if (root == null) {
            return 0;
        }
        int even = 0;
        if (grandparents.size() >= 2 && grandparents.get(grandparents.size() - 2) % 2 == 0) {
            even = root.val;
        }
        List<Integer> copy = new ArrayList<>(grandparents);
        copy.add(root.val);
        int left = sumEvenGrandparent(root.left, copy);
        copy = new ArrayList<>(grandparents);
        copy.add(root.val);
        int right = sumEvenGrandparent(root.right, copy);
        return even + left + right;
    }
}
