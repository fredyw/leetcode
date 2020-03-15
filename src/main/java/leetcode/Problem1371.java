package leetcode;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class Problem1371 {
    public int findTheLongestSubstring(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1371 prob = new Problem1371();
        System.out.println(prob.findTheLongestSubstring("eleetminicoworoep")); // 13
        System.out.println(prob.findTheLongestSubstring("leetcodeisgreat")); // 5
        System.out.println(prob.findTheLongestSubstring("bcbcbc")); // 6
        System.out.println(prob.findTheLongestSubstring("eleetminicoworoepo")); // 18
    }
}
