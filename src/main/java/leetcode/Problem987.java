package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
 */
public class Problem987 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<YValue>> map = new TreeMap<>();
        verticalTraversal(root, 0, 0, map);
        List<List<Integer>> answer = new ArrayList<>();
        map.forEach((key, value) -> {
            Collections.sort(value, (a, b) -> Integer.compare(b.y, a.y));
            List<Integer> sub = new ArrayList<>();
            for (YValue v : value) {
                sub.add(v.value);
            }
            answer.add(sub);
        });
        return answer;
    }

    private static class YValue {
        private final int y;
        private final int value;

        public YValue(int y, int value) {
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return y + " -> " + value;
        }
    }

    private static void verticalTraversal(TreeNode root, int x, int y,
                                          Map<Integer, List<YValue>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new YValue(y, root.val));
        verticalTraversal(root.left, x - 1, y - 1, map);
        verticalTraversal(root.right, x + 1, y - 1, map);
    }

    public static void main(String[] args) {
        Problem987 prob = new Problem987();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(prob.verticalTraversal(root)); // [[9],[3,15],[20],[7]]

        root = new TreeNode(0);
        root.left = new TreeNode(8);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(4);
        root.right.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.left.left = new TreeNode(6);
        System.out.println(prob.verticalTraversal(root)); // [[8],[0,3,6],[1,4,5],[2,7]]

        root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.left.right = new TreeNode(7);
        root.left.left.left.right.left = new TreeNode(10);
        root.left.left.left.right.right = new TreeNode(8);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.left = new TreeNode(6);
        root.left.left.right.left.left = new TreeNode(11);
        root.left.left.right.left.right = new TreeNode(9);
        System.out.println(prob.verticalTraversal(root)); // [[4,10,11],[3,6,7],[2,5,8,9],[0],[1]]
    }
}
