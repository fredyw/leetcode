package leetcode;

/**
 * https://leetcode.com/problems/ransom-note/
 */
public class Problem383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem383 prob = new Problem383();
        System.out.println(prob.canConstruct("a", "b")); // false
        System.out.println(prob.canConstruct("aa", "ab")); // false
        System.out.println(prob.canConstruct("aa", "aab")); // true
    }
}
