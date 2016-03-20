package leetcode;

/**
 * https://leetcode.com/problems/counting-bits/
 */
public class Problem338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = i;
            int count = 0;
            while (n > 0) {
                if ((n & 1) == 1) {
                    count++;
                }
                n >>= 1;
            }
            result[i] = count;
        }
        return result;
    }
}
