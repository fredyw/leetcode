package leetcode;

/**
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
 */
public class Problem5295 {
    public int[] sumZero(int n) {
        int[] answer = new int[n];
        int index = 0;
        for (int i = 1; i <= n / 2; i++) {
            answer[index++] = i;
            answer[index++] = -i;
        }
        if (n % 2 != 0) {
            answer[index] = 0;
        }
        return answer;
    }
}
