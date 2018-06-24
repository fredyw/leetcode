package leetcode;

/**
 * https://leetcode.com/problems/buddy-strings/
 */
public class Problem859 {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int idx1 = 0;
        int idx2 = 0;
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (count == 0) {
                    idx1 = i;
                } else if (count == 1) {
                    idx2 = i;
                } else {
                    return false;
                }
                count++;
            }
        }
        return (A.charAt(idx1) == B.charAt(idx2) &&
            A.charAt(idx2) == B.charAt(idx1));
    }

    public static void main(String[] args) {
        Problem859 prob = new Problem859();
        System.out.println(prob.buddyStrings("ab", "ba")); // true
        System.out.println(prob.buddyStrings("ab", "ab")); // false
        System.out.println(prob.buddyStrings("aa", "aa")); // true
        System.out.println(prob.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(prob.buddyStrings("", "aa")); // false
        System.out.println(prob.buddyStrings("abc", "cba")); // true
        System.out.println(prob.buddyStrings("aab", "aab")); // true
        System.out.println(prob.buddyStrings("aba", "aba")); // true
    }
}
