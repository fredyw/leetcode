package leetcode;

/**
 * https://leetcode.com/problems/get-maximum-in-generated-array/
 */
public class Problem1646 {
    public int getMaximumGenerated(int n) {
        int answer = 0;
        int[] array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                array[i] = 1;
            } else if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else if (i % 2 != 0) {
                array[i] = array[i / 2] + array[(i / 2) + 1];
            }
            answer = Math.max(answer, array[i]);
        }
        return answer;
    }
}
