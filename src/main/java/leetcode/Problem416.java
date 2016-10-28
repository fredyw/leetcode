package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class Problem416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return canPartition(nums, sum, 0, 0, new HashMap<>());
    }

    private static boolean canPartition(int[] nums, int sum, int idx, int accu,
                                        Map<Integer, Boolean> memo) {
        if (idx == nums.length) {
            if (accu == sum - accu) {
                return true;
            }
            return false;
        }
        if (memo.containsKey(accu)) {
            return memo.get(accu);
        }
        boolean found = false;
        found |= canPartition(nums, sum, idx + 1, accu + nums[idx], memo);
        found |= canPartition(nums, sum, idx + 1, accu, memo);
        memo.put(accu, found);
        return found;
    }
}
