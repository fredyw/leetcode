package leetcode;

/**
 * https://leetcode.com/problems/convert-to-base-2/
 */
public class Problem1017 {
    public String baseNeg2(int N) {
        if (N == 0) {
            return "0";
        }
        StringBuilder answer = new StringBuilder();
        int n = N;
        while (n != 0) {
            answer.append((n & 1) == 1 ? 1 : 0);
            n = -(n >> 1);
        }
        return answer.reverse().toString();
    }
}
