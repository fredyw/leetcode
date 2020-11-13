package leetcode;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 */
public class Problem1647 {
    public int minDeletions(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1647 prob = new Problem1647();
        System.out.println(prob.minDeletions("aab")); // 0
        System.out.println(prob.minDeletions("aaabbbcc")); // 2
        System.out.println(prob.minDeletions("ceabaacb")); // 2
    }
}
