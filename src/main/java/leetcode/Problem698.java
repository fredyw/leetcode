package leetcode;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class Problem698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // TODO
        return false;
    }

    private static boolean canPartition(int[] nums, int k, int idx) {
        if (k == 0 && idx == nums.length) {
            return true;
        }
        if (k == 0 && idx < nums.length) {
            return false;
        }
        for (int i = idx; i < nums.length; i++) {
            // TODO
        }
        return false;
    }

    public static void main(String[] args) {
        Problem698 prob = new Problem698();
        System.out.println(prob.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4)); // true
        System.out.println(prob.canPartitionKSubsets(new int[]{5, 3, 2, 3, 4, 2, 1},4)); // true
    }
}
