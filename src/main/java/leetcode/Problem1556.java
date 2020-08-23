package leetcode;

/**
 * https://leetcode.com/problems/thousand-separator/
 */
public class Problem1556 {
    public String thousandSeparator(int n) {
        String answer = "";
        String s = "" + n;
        int i = s.length();
        for (; i - 3 >= 0; i -= 3) {
            String sub = s.substring(i - 3, i);
            if (answer.isEmpty()) {
                answer = sub;
            } else {
                answer = sub + "." + answer;
            }
        }
        if (i > 0) {
            if (answer.isEmpty()) {
                answer = s;
            } else {
                answer = s.substring(0, i) + "." + answer;
            }
        }
        return answer;
    }
}
