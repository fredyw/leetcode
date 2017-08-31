package leetcode;

/**
 * https://leetcode.com/problems/beautiful-arrangement-ii/
 */
public class Problem667 {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int idx = 0;
        boolean add = true;
        int j = k;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[idx++] = i + 1;
                continue;
            }
            if (j > 0) {
                int a;
                if (add) {
                    a = result[i - 1] + j;
                    add = false;
                } else {
                    a = result[i - 1] - j;
                    add = true;
                }
                result[idx++] = a;
            } else if (j == 0) {
                result[idx++] = result[1] + 1;
            } else {
                result[idx++] = result[i - 1] + 1;
            }
            j--;
        }
        return result;
    }
}
