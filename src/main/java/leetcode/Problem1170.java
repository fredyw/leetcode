package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
 */
public class Problem1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] answer = new int[queries.length];
        int i = 0;
        int[] queryMinFreqs = getMinFreqs(queries);
        int[] wordMinFreqs = getMinFreqs(words);
        for (int query : queryMinFreqs) {
            int count = 0;
            for (int word : wordMinFreqs) {
                if (query < word) {
                    count++;
                }
            }
            answer[i++] = count;
        }
        return answer;
    }

    private static int[] getMinFreqs(String[] strings) {
        int[][] counts = new int[strings.length][];
        int i = 0;
        for (String str : strings) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            counts[i++] = count;
        }
        int[] minFreqs = new int[strings.length];
        for (int j = 0; j < counts.length; j++) {
            for (int k = 0; k < counts[j].length; k++) {
                if (counts[j][k] > 0) {
                    minFreqs[j] = counts[j][k];
                    break;
                }
            }
        }
        return minFreqs;
    }
}
