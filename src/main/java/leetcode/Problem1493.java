package leetcode;

/**
 * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class Problem1493 {
    public int longestSubarray(int[] nums) {
        int answer = 0;
        int prevLen = 0;
        int curLen = 0;
        int nZeros = 0;
        boolean addPrev = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curLen++;
                nZeros = 0;
            } else {
                if (i - 1 >= 0 && nums[i - 1] == 1) {
                    prevLen = curLen;
                    curLen = 0;
                }
                nZeros++;
                addPrev = nZeros == 1;
            }
            answer = Math.max(answer, addPrev ? prevLen + curLen : curLen);
        }
        return answer == nums.length ? answer - 1 : answer;
    }
}
