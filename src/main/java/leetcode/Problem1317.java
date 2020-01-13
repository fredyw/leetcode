package leetcode;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 */
public class Problem1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] answer = new int[2];
        for (int i = 1; i <= n; i++) {
            int a = i;
            int b = n - a;
            if (Integer.toString(a).contains("0") || Integer.toString(b).contains("0")) {
                continue;
            }
            answer[0] = a;
            answer[1] = b;
            break;
        }
        return answer;
    }
}
