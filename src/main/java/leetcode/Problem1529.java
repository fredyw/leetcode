package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-iv/
 */
public class Problem1529 {
    public int minFlips(String target) {
        int i = target.length() - 1;
        boolean one = target.charAt(target.length() - 1) == '1';
        int answer = one ? -1 : 0;
        while (i >= 0) {
            if (one) {
                answer += 2;
            }
            while (i >= 0 && target.charAt(i) == (one ? '1' : '0')) {
                i--;
            }
            if (i >= 0) {
                one = target.charAt(i) == '1';
            }
        }
        return answer;
    }
}
