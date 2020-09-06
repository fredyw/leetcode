package leetcode;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class Problem1576 {
    public String modifyString(String s) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (i - 1 >= 0) {
                        char prev = answer.charAt(i - 1);
                        if (prev == c) {
                            continue;
                        }
                    }
                    if (i + 1 < s.length()) {
                        char next = s.charAt(i + 1);
                        if (next == c) {
                            continue;
                        }
                    }
                    answer += c;
                    break;
                }
            } else {
                answer += s.charAt(i);
            }
        }
        return answer;
    }
}
