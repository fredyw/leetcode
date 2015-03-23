package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class Problem98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);
        Set<Integer> sortedValues = new TreeSet<>();
        for (int v : values) {
            sortedValues.add(v);
        }
        return values.equals(new ArrayList<>(sortedValues));
    }
    
    private void inOrder(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrder(node.left, values);
        values.add(node.val);
        inOrder(node.right, values);
    }
}
