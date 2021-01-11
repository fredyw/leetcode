package leetcode;

/**
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 */
public class Problem1716 {
    public int totalMoney(int n) {
        int answer = 0;
        int week = (int) Math.ceil(n / 7.0);
        for (int i = 1; i <= week && n > 0; i++) {
            for (int j = 0; j < 7 && n > 0; j++) {
                answer += i + j;
                n--;
            }
        }
        return answer;
    }
}
