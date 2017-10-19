package leetcode;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class Problem698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int sub = sum / k;
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, sub, 0, k, sub, visited);
    }

    private static boolean canPartition(int[] nums, int originalSub, int idx, int k, int sub,
                                        boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (sub == 0) {
            return canPartition(nums, originalSub, 0, k - 1, originalSub, visited);
        }
        for (int i = idx; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            if (canPartition(nums, originalSub, i + 1, k, sub - nums[i], visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
