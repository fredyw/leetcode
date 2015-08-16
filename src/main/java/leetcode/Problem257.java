package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class Problem257 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        binaryTreePaths(root, "", paths);
        return paths;
    }
    
    private void binaryTreePaths(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            paths.add(path);
            return;
        }
        String newPath = "";
        if (path.isEmpty()) {
            newPath = Integer.toString(node.val);
        } else {
            newPath = path + "->" + Integer.toString(node.val);
        }
        if (node.left != null) {
            binaryTreePaths(node.left, newPath, paths);
        }
        if (node.right != null) {
            binaryTreePaths(node.right, newPath, paths);
        }
        if (node.left == null && node.right == null) {
            binaryTreePaths(node.left, newPath, paths);
        }
    }
}
