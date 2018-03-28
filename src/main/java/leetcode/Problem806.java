package leetcode;

/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 */
public class Problem806 {
    public int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        result[0] = 1;
        int count = 0;
        for (char c : S.toCharArray()) {
            if (count + widths[c - 'a'] > 100) {
                count = widths[c - 'a'];
                result[0]++;
            } else {
                count += widths[c - 'a'];
            }
        }
        result[1] = count;
        return result;
    }
}
