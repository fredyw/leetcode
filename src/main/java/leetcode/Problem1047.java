package leetcode;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class Problem1047 {
    public String removeDuplicates(String S) {
        String answer = S;
        int i = 0;
        while (i < answer.length() - 1) {
            if (answer.charAt(i) == answer.charAt(i + 1)) {
                answer = answer.substring(0, i) + (i + 2 < answer.length() ? answer.substring(i + 2) : "");
                i--;
                if (i < 0) {
                    i = 0;
                }
            } else {
                i++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1047 prob = new Problem1047();
        System.out.println(prob.removeDuplicates("abbaca")); // ca
        System.out.println(prob.removeDuplicates("aabbaca")); // aca
        System.out.println(prob.removeDuplicates("cabbac")); //
    }
}
