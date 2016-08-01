package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem113 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Path> paths = new ArrayList<>();
        pathSum(root, 0, new ArrayList<>(), paths);
        for (Path path : paths) {
            if (path.sum == sum) {
                result.add(path.path);
            }
        }
        return result;
    }

    private static class Path {
        int sum;
        List<Integer> path;

        public Path(int sum, List<Integer> path) {
            this.sum = sum;
            this.path = path;
        }
    }

    private void pathSum(TreeNode node, int sum, List<Integer> path, List<Path> paths) {
        if (node == null) {
            paths.add(new Path(sum, path));
            return;
        }
        List<Integer> newPath = new ArrayList<>(path);
        newPath.add(node.val);
        if (node.left == null && node.right == null) {
            pathSum(node.left, sum + node.val, newPath, paths);
            return;
        }
        if (node.left != null) {
            pathSum(node.left, sum + node.val, newPath, paths);
        }
        if (node.right != null) {
            pathSum(node.right, sum + node.val, newPath, paths);
        }
    }
}
