package leetcode;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */
public class Problem1358 {
    public int numberOfSubstrings(String s) {
        int a = 0;
        int b = 0;
        int c = 0;
        int cur = 0;
        int prev = 0;
        int answer = 0;
        while (cur < s.length()) {
            if (s.charAt(cur) == 'a') {
                a++;
            } else if (s.charAt(cur) == 'b') {
                b++;
            } else {
                c++;
            }
            if (a > 0 && b > 0 && c > 0) {
                answer += s.length() - cur;
                while (a > 0 && b > 0 && c > 0) {
                    if (s.charAt(prev) == 'a') {
                        a--;
                    } else if (s.charAt(prev) == 'b') {
                        b--;
                    } else {
                        c--;
                    }
                    if (a > 0 && b > 0 && c > 0) {
                        answer += s.length() - cur;
                    }
                    prev++;
                }
            }
            cur++;
        }
        return answer;
    }
}
