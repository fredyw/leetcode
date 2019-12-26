package leetcode;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 */
public class Problem1295 {
    public int findNumbers(int[] nums) {
        int answer = 0;
        for (int num : nums) {
            answer += Integer.toString(num).length() % 2 == 0 ? 1 : 0;
        }
        return answer;
    }
}
