package leetcode;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Problem91 {
    public int numDecodings(String s) {
        Integer[] memo = new Integer[s.length()];
        return numDecodings(s, 0, memo);
    }

    private static int numDecodings(String s, int idx, Integer[] memo) {
        if (idx == s.length()) {
            return 1;
        }
        if (memo[idx] != null) {
            return memo[idx];
        }
        int answer = 0;
        if (idx + 1 <= s.length()) {
            int n1 = Integer.parseInt(s.substring(idx, idx + 1));
            if (1 <= n1 && n1 <= 9) {
                answer += numDecodings(s, idx + 1, memo);
            }
        }
        if (idx + 2 <= s.length()) {
            int n2 = Integer.parseInt(s.substring(idx, idx + 2));
            if (10 <= n2 && n2 <= 26) {
                answer += numDecodings(s, idx + 2, memo);
            }
        }
        memo[idx] = answer;
        return answer;
    }
}
