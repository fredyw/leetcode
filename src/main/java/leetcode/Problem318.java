package leetcode;

/**
 * https://leetcode.com/problems/maximum-product-of-word-lengths/
 */
public class Problem318 {
    public int maxProduct(String[] words) {
        int[] set = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (char c : words[i].toCharArray()) {
                int bit = c - 97;
                val |= 1 << bit;
            }
            set[i] = val;
        }
        int max = 0;
        for (int i = 0; i < set.length; i++) {
            for (int j = i; j < set.length; j++) {
                int val = set[i] & set[j];
                if (val == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
