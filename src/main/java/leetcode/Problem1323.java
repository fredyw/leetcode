package leetcode;

/**
 * https://leetcode.com/problems/maximum-69-number/
 */
public class Problem1323 {
    public int maximum69Number (int num) {
        String answer = Integer.toString(num);
        String s = Integer.toString(num);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                answer = answer.substring(0, i) + '9' + answer.substring(i + 1);
                break;
            }
        }
        return Integer.parseInt(answer);
    }
}
