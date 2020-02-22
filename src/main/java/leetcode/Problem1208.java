package leetcode;

/**
 * https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
public class Problem1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int size = s.length();
        int prev = 0;
        int answer = 0;
        int cost = maxCost;
        for (int cur = 0; cur < size; cur++) {
            int diff = Math.abs(s.charAt(cur) - t.charAt(cur));
            if (diff > maxCost) {
                cost = maxCost;
                answer = Math.max(answer, cur - prev);
                prev = cur + 1;
                continue;
            }
            cost -= diff;
            if (cost < 0) {
                answer = Math.max(answer, cur - prev);
                cost += Math.abs(s.charAt(prev) - t.charAt(prev));
                prev++;
            }
        }
        if (cost >= 0) {
            answer = Math.max(answer, size - prev);
        }
        return answer;
    }
}
