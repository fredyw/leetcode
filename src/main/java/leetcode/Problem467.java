package leetcode;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 */
public class Problem467 {
    public int findSubstringInWraproundString(String p) {
        int count = 0;
        int[] counts = new int[26];
        for (int prev = -1, current = 0; current < p.length(); current++) {
            if (prev != -1 && (p.charAt(prev) + 1 - 'a') % 26 == p.charAt(current) - 'a') {
                count += current - prev;
            } else {
                count = 1;
            }
            prev = current;
            counts[p.charAt(current) - 'a'] = Math.max(counts[p.charAt(current) - 'a'], count);
        }
        int sum = 0;
        for (int c : counts) {
            sum += c;
        }
        return sum;
    }
}
