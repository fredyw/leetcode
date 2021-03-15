package leetcode;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class Problem1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1790 prob = new Problem1790();
        System.out.println(prob.areAlmostEqual("bank", "kanb")); // true
        System.out.println(prob.areAlmostEqual("attack", "defend")); // false
        System.out.println(prob.areAlmostEqual("kelb", "kelb")); // true
        System.out.println(prob.areAlmostEqual("abcd", "dcba")); // false
    }
}
