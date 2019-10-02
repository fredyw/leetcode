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
            String tmp = "";
            int i = 0;
            while (i < answer.length() - 1) {
                if (answer.charAt(i) == answer.charAt(i + 1)) {
                    count++;
                } else {
                    count = 1;
                }
                tmp += answer.charAt(i);
                if (count == k) {
                    tmp += answer.charAt(i + 1);
                    tmp = tmp.substring(0, tmp.length() - k);
                    found = true;
                    i++;
                    count = 1;
                }
                i++;
            }
            if (!found) {
                break;
            }
            answer = tmp + (i < answer.length() ? answer.charAt(i) : "");
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Problem1209 prob = new Problem1209();
        System.out.println(prob.removeDuplicates("abcd", 2)); // "abcd"
        System.out.println(prob.removeDuplicates("deeedbbcccbdaa", 3)); // "aa"
        System.out.println(prob.removeDuplicates("pbbcggttciiippooaais", 2)); // "ps"
    }
}
