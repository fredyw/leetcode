package leetcode;

/**
 * https://leetcode.com/problems/repeated-substring-pattern/
 */
public class Problem459 {
    public boolean repeatedSubstringPattern(String str) {
        if (str.isEmpty() || str.length() == 1) {
            return false;
        }
        String sub1 = "" + str.charAt(0);
        String sub2 = "";
        int i = 0;
        i++;
        while (i < str.length() && i + sub1.length() <= str.length()) {
            sub2 = str.substring(i, i + sub1.length());
            if (sub1.equals(sub2)) {
                i += sub1.length();
            } else {
                sub1 += str.charAt(i);
                i++;
            }
        }
        return sub1.equals(sub2) && i == str.length();
    }

    public static void main(String[] args) {
        Problem459 prob = new Problem459();
//        System.out.println(prob.repeatedSubstringPattern("abab")); // true
//        System.out.println(prob.repeatedSubstringPattern("aba")); // false
//        System.out.println(prob.repeatedSubstringPattern("abcabcabcabc")); // true
//        System.out.println(prob.repeatedSubstringPattern("abcabca")); // false
//        System.out.println(prob.repeatedSubstringPattern("")); // false
//        System.out.println(prob.repeatedSubstringPattern("abac")); // false
//        System.out.println(prob.repeatedSubstringPattern("a")); // false
        System.out.println(prob.repeatedSubstringPattern("abababaaba")); // false
    }
}
