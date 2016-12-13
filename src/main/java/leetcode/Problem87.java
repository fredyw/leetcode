package leetcode;

/**
 * https://leetcode.com/problems/scramble-string/
 */
public class Problem87 {
    public boolean isScramble(String s1, String s2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem87 prob = new Problem87();
        System.out.println(prob.isScramble("rgeat", "great")); // true
        System.out.println(prob.isScramble("rgtae", "great")); // true
        System.out.println(prob.isScramble("abcd", "bdac")); // false
        System.out.println(prob.isScramble("abcd", "acdb")); // true
    }
}
