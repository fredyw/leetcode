package leetcode;

/**
 * https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/
 */
public class Problem1839 {
    public int longestBeautifulSubstring(String word) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1839 prob = new Problem1839();
        System.out.println(prob.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu")); // 13
        System.out.println(prob.longestBeautifulSubstring("aeeeiiiioooauuuaeiou")); // 5
        System.out.println(prob.longestBeautifulSubstring("a")); // 0
    }
}
