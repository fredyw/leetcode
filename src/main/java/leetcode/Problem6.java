package leetcode;

/**
 * https://oj.leetcode.com/problems/zigzag-conversion/
 */
public class Problem6 {
    public String convert(String s, int nRows) {
        if (nRows <= 1) {
            return s;
        }
        String result = "";
        char[] chars = s.toCharArray();
        int step1 = nRows + nRows - 2;
        for (int i = 0; i < nRows; i++) {
            int next1 = i;
            int next2 = i;
            int step2 = step1 - (i * 2);
            while (next1 < chars.length) {
                result += chars[next1];
                next1 += step1;

                if (step2 != step1 && step2 > 0) {
                    next2 += step2;
                    if (next2 < chars.length) {
                        result += chars[next2];
                        next2 = next1;
                    }
                }
            }
        }
        return result;
    }
}
