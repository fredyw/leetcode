package leetcode;

/**
 * https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 */
public class Problem395 {
    public int longestSubstring(String s, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem395 prob = new Problem395();
        System.out.println(prob.longestSubstring("aaabb", 3)); // 3
        System.out.println(prob.longestSubstring("ababbc", 2)); // 5
        System.out.println(prob.longestSubstring("aaabcb", 3)); // 3
        System.out.println(prob.longestSubstring("aaabcbc", 2)); // 7
        System.out.println(prob.longestSubstring("aadabcbc", 2)); // 4
        System.out.println(prob.longestSubstring("aadabcbcd", 2)); // 9
        System.out.println(prob.longestSubstring("aadabdbbdc", 2)); // 9
    }
}
