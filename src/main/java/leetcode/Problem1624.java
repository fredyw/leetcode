package leetcode;

/**
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */
public class Problem1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1624 prob = new Problem1624();
        System.out.println(prob.maxLengthBetweenEqualCharacters("aa")); // 0
        System.out.println(prob.maxLengthBetweenEqualCharacters("abca")); // 2
        System.out.println(prob.maxLengthBetweenEqualCharacters("cbzxy")); // -1
        System.out.println(prob.maxLengthBetweenEqualCharacters("cabbac")); // 4
    }
}
