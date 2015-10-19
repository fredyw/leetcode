package leetcode;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class Problem209 {
    public int minSubArrayLen(int s, int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int sum = 0;
                for (int x = j; x < j+i && x < nums.length; x++) {
                    sum += nums[x];
                }
                if (sum >= s) {
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem209 prob = new Problem209();
//        System.out.println(prob.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
//        System.out.println(prob.minSubArrayLen(3, new int[]{2, 3, 1, 2, 4, 5}));
        System.out.println(prob.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 5}));
    }
}
