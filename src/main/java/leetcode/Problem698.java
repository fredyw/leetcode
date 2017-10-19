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
        Boolean[][] memo = new Boolean[k + 1][sub + 1];
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, sub, k, sub, visited, memo);
    }

    private static boolean canPartition(int[] nums, int originalSub, int k, int sub,
                                        boolean[] visited, Boolean[][] memo) {
        if (k <= 0 || sub < 0) {
            return false;
        }
        if (sub == 0) {
            sub = originalSub;
            k = k - 1;
            if (k == 0) {
                return true;
            }
        }
        if (memo[k][sub] != null) {
            return memo[k][sub];
        }
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            found |= canPartition(nums, originalSub, k, sub - nums[i], visited, memo);
            visited[i] = false;
        }
        memo[k][sub] = found;
        return found;
    }

    public static void main(String[] args) {
        Problem698 prob = new Problem698();
        System.out.println(prob.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4)); // true
        System.out.println(prob.canPartitionKSubsets(new int[]{5, 3, 2, 3, 4, 2, 1}, 4)); // true
        System.out.println(prob.canPartitionKSubsets(new int[]{5, 3, 2, 3, 4, 2, 2}, 4)); // false
        System.out.println(prob.canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3)); // false
        System.out.println(prob.canPartitionKSubsets(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 5)); // true
        System.out.println(prob.canPartitionKSubsets(new int[]{5, 7, 3}, 3)); // false
        System.out.println(prob.canPartitionKSubsets(new int[]{2, 2, 10, 5, 2, 7, 2, 2, 13}, 3)); // true
    }
}
