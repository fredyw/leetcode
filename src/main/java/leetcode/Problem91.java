package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Problem91 {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return decode(s, 0, memo);
    }

    private int decode(String s, int idx, Map<Integer, Integer> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }
        if (idx == s.length()) {
            return 1;
        }
        int result = 0;
        if (idx + 1 <= s.length()) {
            String one = s.substring(idx, idx + 1);
            int num = Integer.parseInt(one);
            if (num >= 1 && num <= 9) {
                result += decode(s, idx + 1, memo);
            }
        }
        if (idx + 2 <= s.length()) {
            String two = s.substring(idx, idx + 2);
            int num = Integer.parseInt(two);
            if (num >= 10 && num <= 26) {
                result += decode(s, idx + 2, memo);
            }
        }
        memo.put(idx, result);
        return result;
    }
}
