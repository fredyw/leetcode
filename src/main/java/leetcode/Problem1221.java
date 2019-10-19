package leetcode;

/**
 * https://leetcode.com/problems/split-a-string-in-balanced-strings/
 */
public class Problem1221 {
    public int balancedStringSplit(String s) {
        int answer = 0;
        int lCount = 0;
        int rCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lCount++;
            } else if (s.charAt(i) == 'R') {
                rCount++;
            }
            if (lCount == rCount) {
                answer++;
                lCount = 0;
                rCount = 0;
            }
        }
        return answer;
    }
}
