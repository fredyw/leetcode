package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
 */
public class Problem1578 {
    public int minCost(String s, int[] cost) {
        int answer = 0;
        int i = 0;
        while (i < s.length()) {
            int max = cost[i];
            int sum = cost[i];
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                max = Math.max(max, cost[i + 1]);
                sum += cost[i + 1];
                count++;
                i++;
            }
            if (count > 1) {
                answer += sum - max;
            }
            i++;
        }
        return answer;
    }
}
