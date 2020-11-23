package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class Problem1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        int answer = 0;
        int prefixSum = 0;
        Set<Integer> set = new HashSet<>();
        set.add(prefixSum);
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (set.contains(prefixSum - target)) {
                answer++;
                set.clear();
            }
            set.add(prefixSum);
        }
        return answer;
    }
}
