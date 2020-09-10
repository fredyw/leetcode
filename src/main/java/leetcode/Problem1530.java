package leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/
 */
public class Problem1530 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int countPairs(TreeNode root, int distance) {
        IntRef answer = new IntRef();
        countPairs(root, distance, answer);
        return answer.val;
    }

    private static class IntRef {
        private int val;
    }

    private static List<Integer> countPairs(TreeNode root, int distance, IntRef answer) {
        if (root == null) {
            return List.of();
        }
        if (root.left == null && root.right == null) {
            return List.of(1);
        }
        List<Integer> left = countPairs(root.left, distance, answer);
        List<Integer> right = countPairs(root.right, distance, answer);
        if (!left.isEmpty() && !right.isEmpty()) {
            answer.val += left.stream()
                .flatMap(e1 -> right.stream().filter(e2 -> e1 + e2 <= distance))
                .count();
            return Stream.concat(
                left.stream().map(e -> e + 1),
                right.stream().map(e -> e + 1))
                .collect(Collectors.toList());
        }
        if (!left.isEmpty()) {
            return left.stream().map(e -> e + 1).collect(Collectors.toList());
        }
        return right.stream().map(e -> e + 1).collect(Collectors.toList());
    }
}
