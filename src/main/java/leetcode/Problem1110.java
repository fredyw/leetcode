package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-and-return-forest/
 */
public class Problem1110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int delete : to_delete) {
            toDelete.add(delete);
        }
        List<TreeNode> answer = new ArrayList<>();
        if (!delNodes(root, toDelete, answer)) {
            answer.add(root);
        }
        return answer;
    }

    private static boolean delNodes(TreeNode current, Set<Integer> toDelete, List<TreeNode> answer) {
        if (current == null) {
            return false;
        }
        boolean delete = toDelete.contains(current.val);
        if (delNodes(current.left, toDelete, answer)) {
            current.left = null;
        }
        if (delNodes(current.right, toDelete, answer)) {
            current.right = null;
        }
        if (delete) {
            if (current.left != null) {
                answer.add(current.left);
            }
            if (current.right != null) {
                answer.add(current.right);
            }
        }
        return delete;
    }
}
