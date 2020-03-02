package leetcode;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
 */
public class Problem1358 {
    public int numberOfSubstrings(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1358 prob = new Problem1358();
        System.out.println(prob.numberOfSubstrings("abcabc")); // 10
        System.out.println(prob.numberOfSubstrings("aaacb")); // 3
        System.out.println(prob.numberOfSubstrings("abc")); // 1
    }
}
