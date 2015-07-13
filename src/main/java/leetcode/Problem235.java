package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class Problem235 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);
        int minSize = Math.min(path1.size(), path2.size());
        TreeNode lca = null;
        for (int i = 0; i < minSize; i++) {
            if (path1.get(i).val != path2.get(i).val) {
                break;
            } else {
                lca = path1.get(i);
            }
        }
        return lca;
    }
    
    private List<TreeNode> getPath(TreeNode root, TreeNode n) {
        List<TreeNode> result = new ArrayList<>();
        getPath(root, n, new ArrayList<>(), result);
        return result;
    }

    private void getPath(TreeNode root, TreeNode n, List<TreeNode> path, List<TreeNode> result) {
        if (root == null) {
            return;
        }
        if (root == n) {
            result.addAll(path);
            result.add(root);
            return;
        }
        List<TreeNode> newPath = new ArrayList<>(path);
        newPath.add(root);
        getPath(root.left, n, newPath, result);
        getPath(root.right, n, newPath, result);
    }
}
