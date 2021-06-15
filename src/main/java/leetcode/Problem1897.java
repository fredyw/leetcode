package leetcode;

/**
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class Problem1897 {
    public boolean makeEqual(String[] words) {
        int[] chars = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                chars[c - 'a']++;
            }
        }
        for (int n : chars) {
            if (n % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
