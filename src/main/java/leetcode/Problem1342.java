package leetcode;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 */
public class Problem1342 {
    public int numberOfSteps (int num) {
        int answer = 0;
        int n = num;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
            }
            answer++;
        }
        return answer;
    }
}
