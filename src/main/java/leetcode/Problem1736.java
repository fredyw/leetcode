package leetcode;

/**
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class Problem1736 {
    public String maximumTime(String time) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != '?') {
                answer.append(time.charAt(i));
                continue;
            }
            if (i == 0) {
                answer.append(time.charAt(1) == '?' || time.charAt(1) - '0' <= 3 ? "2" : "1");
            } else if (i == 1) {
                answer.append(answer.charAt(0) == '2' ? "3" : "9");
            } else if (i == 3) {
                answer.append("5");
            } else if (i == 4) {
                answer.append("9");
            }
        }
        return answer.toString();
    }
}
