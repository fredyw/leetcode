package leetcode;

/**
 * https://leetcode.com/problems/interleaving-string/
 */
public class Problem97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem97 prob = new Problem97();
        System.out.println(prob.isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
        System.out.println(prob.isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
    }
}
