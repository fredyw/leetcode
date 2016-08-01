package leetcode;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class Problem173 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class BSTIterator {
        private LinkedList<Integer> list = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            inOrder(root, list);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !list.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.remove();
        }

        private void inOrder(TreeNode node, LinkedList<Integer> list) {
            if (node == null) {
                return;
            }
            inOrder(node.left, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }
}
