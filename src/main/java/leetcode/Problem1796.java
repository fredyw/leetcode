package leetcode;

/**
 * https://leetcode.com/problems/second-largest-digit-in-a-string/
 */
public class Problem1796 {
    public int secondHighest(String s) {
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                continue;
            }
            int num = c - '0';
            max = Math.max(max, num);
        }
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                continue;
            }
            int num = c - '0';
            if (max == num) {
                continue;
            }
            answer = Math.max(answer, num);
        }
        return answer;
    }
}
