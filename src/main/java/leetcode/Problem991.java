package leetcode;

/**
 * https://leetcode.com/problems/broken-calculator/
 */
public class Problem991 {
    public int brokenCalc(int X, int Y) {
        int answer = 0;
        while (Y > X) {
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            answer++;
        }
        return answer + X - Y;
    }
}
