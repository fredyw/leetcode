package leetcode;

/**
 * https://leetcode.com/problems/diet-plan-performance/
 */
public class Problem1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int answer = 0;
        int[] sums = new int[calories.length];
        for (int i = 0; i < k; i++) {
            sums[k - 1] += calories[i];
        }
        for (int i = 0, j = k; j < calories.length; i++, j++) {
            sums[j] = sums[j - 1] + calories[j] - calories[i];
        }
        for (int i = k - 1; i < sums.length; i++) {
            if (sums[i] < lower) {
                answer--;
            } else if (sums[i] > upper) {
                answer++;
            }
        }
        return answer;
    }
}
