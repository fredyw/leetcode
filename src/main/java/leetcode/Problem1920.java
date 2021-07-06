package leetcode;

/**
 * https://leetcode.com/problems/build-array-from-permutation/
 */
public class Problem1920 {
    public int[] buildArray(int[] nums) {
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[nums[i]];
        }
        return answer;
    }
}
