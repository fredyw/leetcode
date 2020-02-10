package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class Problem1347 {
    public int minSteps(String s, String t) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1347 prob = new Problem1347();
        System.out.println(prob.minSteps("bab", "aba")); // 1
        System.out.println(prob.minSteps("leetcode", "practice")); // 5
        System.out.println(prob.minSteps("anagram", "mangaar")); // 0
        System.out.println(prob.minSteps("xxyyzz", "xxyyzz")); // 0
        System.out.println(prob.minSteps("friend", "family")); // 4
    }
}
