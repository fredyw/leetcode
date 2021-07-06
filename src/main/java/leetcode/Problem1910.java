package leetcode;

/**
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/
 */
public class Problem1910 {
    public String removeOccurrences(String s, String part) {
        String answer = s;
        while (true) {
            String tmp = answer;
            answer = answer.replaceFirst(part, "");
            if (tmp.equals(answer)) {
                break;
            }
        }
        return answer;
    }
}
