package leetcode;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
public class Problem424 {
    public int characterReplacement(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int[] counts = new int[26];
            int sum = 0;
            int tmpMax = 0;
            for (; j < s.length(); j++) {
                char c = s.charAt(j);
                counts[c - 'A']++;
                sum++;
                tmpMax = Math.max(tmpMax, counts[c - 'A']);
                if (sum - tmpMax > k) {
                    sum--;
                    counts[c - 'A']--;
                    break;
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
