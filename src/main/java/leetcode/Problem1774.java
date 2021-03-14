package leetcode;

/**
 * https://leetcode.com/problems/closest-dessert-cost/
 */
public class Problem1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int i = 0;
        MinCost minCost = new MinCost();
        for (int baseCost : baseCosts) {
            if (minCost.value == -1) {
                minCost.value = baseCost;
            }
            closestCost(toppingCosts, target, 0, baseCost, minCost);
        }
        return minCost.value;
    }

    private static class MinCost {
        private int value = -1;
    }

    private static void closestCost(int[] toppingCosts, int target, int index, int cost,
                                    MinCost minCost) {
        if (index == toppingCosts.length || cost > target) {
            if (Math.abs(cost - target) < Math.abs(minCost.value - target)) {
                minCost.value = cost;
            } else if (Math.abs(cost - target) == Math.abs(minCost.value - target)) {
                minCost.value = Math.min(minCost.value, cost);
            }
            return;
        }
        if (Math.abs(cost - target) < Math.abs(minCost.value - target)) {
            minCost.value = cost;
        } else if (Math.abs(cost - target) == Math.abs(minCost.value - target)) {
            minCost.value = Math.min(minCost.value, cost);
        }
        // Skip topping.
        closestCost(toppingCosts, target, index + 1, cost, minCost);
        // Add topping.
        closestCost(toppingCosts, target, index + 1, cost + toppingCosts[index], minCost);
        // Add the same topping twice.
        closestCost(toppingCosts, target, index + 1, cost + (toppingCosts[index] * 2), minCost);
    }
}
