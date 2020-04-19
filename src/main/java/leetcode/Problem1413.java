package leetcode;

/**
 * https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
 */
public class Problem1413 {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        int answer = 1 - min;
        return answer <= 0 ? 1 : answer;
    }
}
