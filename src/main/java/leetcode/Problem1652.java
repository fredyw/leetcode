package leetcode;

/**
 * https://leetcode.com/problems/defuse-the-bomb/
 */
public class Problem1652 {
    public int[] decrypt(int[] code, int k) {
        int[] answer = new int[code.length];
        if (k == 0) {
            return answer;
        }
        int[] sums = new int[code.length];
        for (int i = 0; i < code.length; i++) {
            if (i == 0) {
                sums[i] = code[i];
            } else {
                sums[i] = sums[i - 1] + code[i];
            }
        }
        if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int start = i;
                int end = (i + k) % code.length;
                int val = getValue(sums, start, end);
                answer[i] = val;
            }
        } else {
            for (int i = 0; i < code.length; i++) {
                int start = (i + k - 1) % code.length;
                if (start < 0) {
                    start = code.length + start;
                }
                int end = (i - 1) % code.length;
                if (end < 0) {
                    end = code.length + end;
                }
                int val = getValue(sums, start, end);
                answer[i] = val;
            }
        }
        return answer;
    }

    private static int getValue(int[] sums, int start, int end) {
        return end > start ?
            sums[end] - sums[start] :
            sums[sums.length - 1] - sums[start] + sums[end];
    }
}
