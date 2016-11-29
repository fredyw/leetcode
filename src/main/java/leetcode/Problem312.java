package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/burst-balloons/
 */
public class Problem312 {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Map<String, Integer> memo = new HashMap<>();
        return maxCoins(list, memo);
    }

    private int maxCoins(List<Integer> nums, Map<String, Integer> memo) {
        if (nums.size() == 1) {
            return nums.get(0);
        }
        String key = nums.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            int left = 1;
            int right = 1;
            if (i - 1 >= 0) {
                left = nums.get(i - 1);
            }
            if (i + 1 < nums.size()) {
                right = nums.get(i + 1);
            }
            int val = left * nums.get(i) * right;

            int tmp = nums.get(i);
//            System.out.println("index=" + i);
//            System.out.println(" - before=" + nums);
//            System.out.println(" - val=" + val + " (" + left + " * " + nums.get(i) + " * " + right + ")");
            nums.remove(i);
//            System.out.println(" - after=" + nums);
            max = Math.max(max, maxCoins(nums, memo) + val);
            nums.add(i, tmp);
        }
        memo.put(key, max);
        return max;
    }

    public static void main(String[] args) {
        Problem312 prob = new Problem312();
        System.out.println(prob.maxCoins(new int[]{3, 1, 5, 8})); // 167
//        System.out.println(prob.maxCoins(new int[]{2, 4, 8})); // 88
//        System.out.println(prob.maxCoins(new int[]{2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3, 6})); // 3304
//        System.out.println(prob.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2})); // 3414
    }
}
