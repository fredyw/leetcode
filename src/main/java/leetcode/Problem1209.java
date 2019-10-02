package leetcode;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class Problem1209 {
    public String removeDuplicates(String s, int k) {
        String answer = s;
        while (true) {
            boolean found = false;
            int count = 1;
            StringBuilder tmp = new StringBuilder();
            int i = 0;
            while (i < answer.length() - 1) {
                if (answer.charAt(i) == answer.charAt(i + 1)) {
                    count++;
                } else {
                    count = 1;
                }
                tmp.append(answer.charAt(i));
                if (count == k) {
                    tmp.append(answer.charAt(i + 1));
                    tmp.delete(i - k + 2, tmp.length());
                    found = true;
                    i++;
                    count = 1;
                }
                i++;
            }
            if (!found) {
                break;
            }
            if (i < answer.length()) {
                tmp.append(answer.charAt(i));
            }
            answer = tmp.toString();
        }
        return answer;
    }
}
