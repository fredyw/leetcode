package leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string/
 */
public class Problem567 {
    public boolean checkInclusion(String s1, String s2) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem567 prob = new Problem567();
        System.out.println(prob.checkInclusion("ab", "eidbaooo")); // true
        System.out.println(prob.checkInclusion("ab", "eidboaoo")); // false
    }
}
