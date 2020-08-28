package leetcode;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal/
 */
public class Problem1551 {
    public int minOperations(int n) {
        int answer = 0;
        int m = n / 2;
        int[] array = new int[n];
        array[0] = 1;
        for (int i = 1; i <= m; i++) {
            array[i] = array[i - 1] + 2;
        }
        int mid = array[m];
        if (n % 2 == 0) {
            mid--;
        }
        for (int i = 0; i < m; i++) {
            answer += mid - array[i];
        }
        return answer;
    }
}
