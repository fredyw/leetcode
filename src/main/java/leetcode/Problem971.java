package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
 */
public class Problem971 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> answer = new ArrayList<>();
        boolean b = flipMatchVoyage(root, voyage, new Index(), answer);
        if (!b) {
            answer.clear();
            answer.add(-1);
        }
        return answer;
    }

    private static class Index {
        private int val;

        public Index inc() {
            val++;
            return this;
        }

        public Index dec() {
            val--;
            return this;
        }
    }

    private static boolean flipMatchVoyage(TreeNode current, int[] voyage, Index index,
                                           List<Integer> answer) {
        if (current == null) {
            index.dec();
            return true;
        }
        int val = voyage[index.val];
        if (current.val == val) {
            boolean b = flipMatchVoyage(current.left, voyage, index.inc(), answer);
            if (!b) {
                TreeNode tmp = current.left;
                current.left = current.right;
                current.right = tmp;
                b = flipMatchVoyage(current.left, voyage, index, answer);
                if (!b) {
                    return false;
                }
                answer.add(current.val);
            }
            return flipMatchVoyage(current.right, voyage, index.inc(), answer);
        }
        return false;
    }
}
