package leetcode;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 */
public class Problem1638 {
    public int countSubstrings(String s, String t) {
        int answer = 0;
        int minLength = Math.max(s.length(), t.length());
        for (int length = 1; length <= minLength; length++) {
            for (int i = 0; i <= s.length() - length; i++) {
                String sub1 = s.substring(i, i + length);
                for (int j = 0; j <= t.length() - length; j++) {
                    String sub2 = t.substring(j, j + length);
                    int count = 0;
                    for (int k = 0; k < length; k++) {
                        if (sub1.charAt(k) != sub2.charAt(k)) {
                            count++;
                        }
                        if (count > 1) {
                            break;
                        }
                    }
                    if (count == 1) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1638 prob = new Problem1638();
        System.out.println(prob.countSubstrings("aba", "baba")); // 6
        System.out.println(prob.countSubstrings("ab", "bb")); // 3
        System.out.println(prob.countSubstrings("a", "a")); // 0
        System.out.println(prob.countSubstrings("abe", "bbc")); // 10
        System.out.println(prob.countSubstrings("computer", "computation")); // 90
    }
}
