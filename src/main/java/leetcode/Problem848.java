package leetcode;

/**
 * https://leetcode.com/problems/shifting-letters/
 */
public class Problem848 {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        long totalSum = 0;
        long[] sums = new long[shifts.length];
        for (int i = 0; i < shifts.length; i++) {
            sums[i] = totalSum + shifts[i];
            totalSum += shifts[i];
        }
        for (int i = 0; i < shifts.length; i++) {
            long prevSum = 0;
            if (i - 1 >= 0) {
                prevSum = sums[i - 1];
            }
            long val = (chars[i] - 'a' + (totalSum - prevSum)) % 26;
            chars[i] = (char) ('a' + val);
        }
        return new String(chars);
    }
}
