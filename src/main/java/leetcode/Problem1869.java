package leetcode;

/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 */
public class Problem1869 {
    public boolean checkZeroOnes(String s) {
        int maxZeroCount = 0;
        int tmpZeroCount = 0;
        int maxOneCount = 0;
        int tmpOneCount = 0;
        if (s.charAt(0) == '0') {
            tmpZeroCount = 1;
        } else {
            tmpOneCount = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '0') {
                    tmpZeroCount = 1;
                } else {
                    tmpOneCount = 1;
                }
            } else {
                if (s.charAt(i) == '0') {
                    tmpZeroCount++;
                } else {
                    tmpOneCount++;
                }
            }
            maxZeroCount = Math.max(maxZeroCount, tmpZeroCount);
            maxOneCount = Math.max(maxOneCount, tmpOneCount);
        }
        maxZeroCount = Math.max(maxZeroCount, tmpZeroCount);
        maxOneCount = Math.max(maxOneCount, tmpOneCount);
        return maxOneCount > maxZeroCount;
    }
}
