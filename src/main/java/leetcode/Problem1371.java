package leetcode;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class Problem1371 {
    public int findTheLongestSubstring(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
                s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                // TODO
            }
        }
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
