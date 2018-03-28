package leetcode;

import java.util.Arrays;

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

    public static void main(String[] args) {
        Problem806 prob = new Problem806();
        System.out.println(Arrays.toString(prob.numberOfLines(new int[]{
                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            "abcdefghijklmnopqrstuvwxyz"))); // [3, 60]
        System.out.println(Arrays.toString(prob.numberOfLines(new int[]{
                4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
            "bbbcccdddaaa"
        ))); // [2, 4]
    }
}
