package leetcode;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 */
public class Problem1929 {
    public int[] getConcatenation(int[] nums) {
        int[] answer = new int[nums.length * 2];
        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < nums.length; j++) {
                answer[index++] = nums[j];
            }
        }
        return answer;
    }
}
