package leetcode;

/**
 * https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/
 */
public class Problem1318 {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        while (a > 0 || b > 0 || c > 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    answer++;
                }
            } else { // (c & 1) == 0
                if ((a & 1) == 1 && (b & 1) == 1) {
                    answer += 2;
                } else if ((a & 1) == 1 || (b & 1) == 1) {
                    answer++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return answer;
    }
}
