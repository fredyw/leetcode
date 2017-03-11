package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class Problem410 {
    public int splitArray(int[] nums, int m) {
        int[] sums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                sums[i] = nums[i];
            } else {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
        return splitArray(nums, sums, m, 0, new ArrayList<>());
    }

    private static int splitArray(int[] nums, int[] sums, int m, int idx, List<Integer> subList) {
        if (m <= 1) {
            subList.add(sums[nums.length - 1]);
            int max = 0;
            for (int i = subList.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    max = Math.max(max, subList.get(i));
                } else {
                    max = Math.max(max, subList.get(i) - subList.get(i - 1));
                }
            }
            return max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < nums.length; i++) {
            List<Integer> newSubList = new ArrayList<>(subList);
            newSubList.add(sums[i]);
            min = Math.min(min, splitArray(nums, sums, m - 1, i + 1, newSubList));
        }
        return min;
    }

    public static void main(String[] args) {
        Problem410 prob = new Problem410();
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 2)); // 18
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 3)); // 14
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 4)); // 10
        System.out.println(prob.splitArray(new int[]{7, 2, 5, 10, 8}, 5)); // 10
    }
}
