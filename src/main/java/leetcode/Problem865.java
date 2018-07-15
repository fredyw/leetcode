package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
 */
public class Problem865 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // TODO
        return null;
    }

    private static TreeNode deserialize(String str) {
        String[] nodes = str.substring(1, str.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int idx = 0;
        String val = nodes[idx];
        if (val.isEmpty()) {
            return null;
        }
        TreeNode root = null;
        queue.add(new TreeNode(Integer.parseInt(val)));
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            if (idx == 0) {
                root = parent;
            }
            if (++idx < nodes.length) {
                if (!nodes[idx].equals("null")) {
                    parent.left = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.left);
                }
            }
            if (++idx < nodes.length) {
                if (!nodes[idx].equals("null")) {
                    parent.right = new TreeNode(Integer.parseInt(nodes[idx]));
                    queue.add(parent.right);
                }
            }
        }
        return root;
    }

    public static String serialize(TreeNode node) {
        if (node == null) {
            return "[]";
        }
        List<String> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        nodes.add(Integer.toString(node.val));
        while (!queue.isEmpty()) {
            TreeNode parent = queue.remove();
            if (parent.left == null) {
                nodes.add("null");
            } else {
                queue.add(parent.left);
                nodes.add(Integer.toString(parent.left.val));
            }
            if (parent.right == null) {
                nodes.add("null");
            } else {
                queue.add(parent.right);
                nodes.add(Integer.toString(parent.right.val));
            }
        }
        // remove all the nulls from behind
        int i = nodes.size() - 1;
        while (nodes.get(i).equals("null")) {
            i--;
        }
        nodes = nodes.subList(0, i + 1);
        return "[" + nodes.stream().collect(Collectors.joining(",")) + "]";
    }

    public static void main(String[] args) {
        Problem865 prob = new Problem865();
        System.out.println(serialize(
            prob.subtreeWithAllDeepest(deserialize(
                "[3,5,1,6,2,0,8,null,null,7,4]")))); // [2,7,4]
        System.out.println(serialize(
            prob.subtreeWithAllDeepest(deserialize(
                "[3,5,1,6,2,0,8,null,null,7,4,null,null,null,null,9]")))); // [9]
    }
}
