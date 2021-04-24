package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-ice-cream-bars/
 */
public class Problem1833 {
    public int maxIceCream(int[] costs, int coins) {
        int answer = 0;
        int currentCoins = coins;
        Arrays.sort(costs);
        for (int cost : costs) {
            if (currentCoins - cost >= 0) {
                currentCoins -= cost;
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}
