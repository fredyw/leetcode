package leetcode;

/**
 * https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/
 */
public class Problem1974 {
    public int minTimeToType(String word) {
        int answer = 0;
        int s = 'a';
        for (char c : word.toCharArray()) {
            int diff1 = Math.abs(c - s);
            int diff2 = Math.abs(s + 26 - c);
            int diff3 = Math.abs(c + 26 - s);
            answer += Math.min(diff1, Math.min(diff2, diff3)) + 1;
            s = c;
        }
        return answer;
    }
}
