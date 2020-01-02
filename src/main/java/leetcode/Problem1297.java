package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
 */
public class Problem1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1297 prob = new Problem1297();
        System.out.println(prob.maxFreq("aababcaab", 2, 3, 4)); // 2
        System.out.println(prob.maxFreq("aaaa", 1, 3, 3)); // 2
        System.out.println(prob.maxFreq("aabcabcab", 2, 2, 3)); // 3
        System.out.println(prob.maxFreq("abcde", 2, 3, 3)); // 0
    }
}
