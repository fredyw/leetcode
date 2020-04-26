package leetcode;

/**
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class Problem1422 {
    public int maxScore(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        int answer = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0' && i == s.length() - 1) {
                continue;
            }
            if (s.charAt(i) == '0') {
                left++;
            } else if (s.charAt(i) == '1') {
                right++;
            }
            answer = Math.max(answer, Math.abs(left + (ones - right)));
        }
        return answer;
    }
}
