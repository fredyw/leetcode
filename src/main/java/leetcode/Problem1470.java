package leetcode;

/**
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class Problem1470 {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int j = n;
        int[] answer = new int[nums.length];
        int l = 0;
        for (int k = 0; k < n; k++) {
            answer[l++] = nums[i++];
            answer[l++] = nums[j++];
        }
        return answer;
    }
}
