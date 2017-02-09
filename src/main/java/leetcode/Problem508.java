package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/
 */
public class Problem508 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        IntRef max = new IntRef();
        findFrequentTreSum(root, map, max);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max.val) {
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static class IntRef {
        private int val;
    }

    private static int findFrequentTreSum(TreeNode node, Map<Integer, Integer> map, IntRef max) {
        if (node == null) {
            return 0;
        }
        int left = findFrequentTreSum(node.left, map, max);
        int right = findFrequentTreSum(node.right, map, max);
        int sum = node.val + left + right;
        if (!map.containsKey(sum)) {
            int newCount = 1;
            max.val = Math.max(max.val, newCount);
            map.put(sum, newCount);
        } else {
            int newCount = map.get(sum) + 1;
            max.val = Math.max(max.val, newCount);
            map.put(sum, newCount);
        }
        return sum;
    }
}
