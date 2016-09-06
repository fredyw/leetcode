package leetcode;

/**
 * https://leetcode.com/problems/is-subsequence/
 */
public class Problem392 {
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            for (int j = idx; j < t.length(); j++) {
                char c2 = t.charAt(j);
                if (c1 == c2) {
                    idx = j + 1;
                    count++;
                    break;
                }
            }
        }
        return count == s.length();
    }

    public static void main(String[] args) {
        Problem392 prob = new Problem392();
        System.out.println(prob.isSubsequence("ace", "abcde")); // true
        System.out.println(prob.isSubsequence("aec", "abcde")); // false
        System.out.println(prob.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(prob.isSubsequence("axc", "ahbgdc")); // false
    }
}
