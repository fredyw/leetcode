package leetcode;

/**
 * https://leetcode.com/problems/total-hamming-distance/
 */
public class Problem477 {
    public int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                count += 1 & (nums[j] >> i);
            }
            result += (nums.length - count) * count;
        }
        return result;
    }
}
