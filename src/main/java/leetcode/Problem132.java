package leetcode;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */
public class Problem132 {
    public int minCut(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem132 prob = new Problem132();
        System.out.println(prob.minCut("aab")); // 1
        System.out.println(prob.minCut("aaa")); // 0
        System.out.println(prob.minCut("bbaaaaabb")); // 0
        System.out.println(prob.minCut("baaaaabb")); // 1
    }
}
