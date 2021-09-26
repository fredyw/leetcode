package leetcode;

/**
 * https://leetcode.com/problems/maximum-difference-between-increasing-elements/
 */
public class Problem2016 {
    public int maximumDifference(int[] nums) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            answer = Math.max(answer, num - min);
        }
        return answer == 0 ? -1 : answer;
    }
}
