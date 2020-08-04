package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
 */
public class Problem1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            list.add(sum);
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list);
        long answer = 0;
        for (int i = left - 1; i < right; i++) {
            answer += list.get(i);
        }
        return (int) (answer  % 1_000_000_007);
    }
}
