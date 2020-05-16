package leetcode;

/**
 * https://leetcode.com/problems/consecutive-characters/
 */
public class Problem1446 {
    public int maxPower(String s) {
        int answer = 1;
        int tmp = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                tmp++;
            } else {
                tmp = 1;
            }
            answer = Math.max(answer, tmp);
        }
        return answer;
    }
}
