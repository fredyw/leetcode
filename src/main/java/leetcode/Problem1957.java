package leetcode;

/**
 * https://leetcode.com/problems/delete-characters-to-make-fancy-string/
 */
public class Problem1957 {
    public String makeFancyString(String s) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int count = 0;
            char c = s.charAt(i);
            while (i < s.length() && c == s.charAt(i)) {
                count++;
                i++;
            }
            if (count >= 2) {
                answer.append(c).append(c);
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }
}
