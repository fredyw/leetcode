package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/trim-a-binary-search-tree/
 */
public class Problem669 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        int lidx = Collections.binarySearch(list, L);
        if (lidx < 0) {
            lidx = -(lidx);
        }
        int ridx = Collections.binarySearch(list, R);
        if (ridx < 0) {
            ridx = -(ridx) - 2;
        }
        List<Integer> subList = list.subList(lidx, ridx + 1);
        TreeNode result = null;
        for (int i = 0; i < subList.size(); i++) {
            result = build(result, subList.get(i));
        }
        return result;
    }

    private static TreeNode build(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val <= node.val) {
            node.left = build(node.left, val);
        } else {
            node.right = build(node.right, val);
        }
        return node;
    }

    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }

    public static void main(String[] args) {
        Problem669 prob = new Problem669();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        TreeNode treeNode = prob.trimBST(root, 1, 2);
        System.out.println(treeNode);

        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        treeNode = prob.trimBST(root, 1, 3);
        System.out.println(treeNode);
    }
}
