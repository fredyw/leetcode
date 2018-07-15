package leetcode;

/**
 * https://leetcode.com/problems/binary-gap/
 */
public class Problem868 {
    public int binaryGap(int N) {
        int n = N;
        int max = 0;
        int gap = 0;
        int count = 0;
        while (n > 0) {
            int i = n & 1;
            if (i == 1) {
                count++;
                if (count >= 2) {
                    max = Math.max(max, gap + 1);
                }
                gap = 0;
            } else if (count >= 1) {
                gap++;
            }
            n >>= 1;
        }
        return max;
    }
}
