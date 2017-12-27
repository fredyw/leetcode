package leetcode;

/**
 * https://leetcode.com/problems/delete-and-earn/
 */
public class Problem740 {
    public int deleteAndEarn(int[] nums) {
        int[] sums = new int[10002];
        for (int i = 0; i < nums.length; i++) {
            sums[nums[i]] += nums[i];
        }
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem740 prob = new Problem740();
        System.out.println(prob.deleteAndEarn(new int[]{3, 4, 2})); // 6
        System.out.println(prob.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})); // 9
    }
}
