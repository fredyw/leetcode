package leetcode;

/**
 * https://leetcode.com/problems/water-bottles/
 */
public class Problem1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = 0;
        while (numBottles > 0) {
            numBottles -= numExchange;
            if (numBottles < 0) {
                answer += numExchange + numBottles;
            } else {
                answer += numExchange;
            }
            numBottles++;
        }
        return answer;
    }
}
