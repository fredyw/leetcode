package leetcode;

/**
 * https://leetcode.com/problems/diet-plan-performance/
 */
public class Problem1176 {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1176 prob = new Problem1176();
        System.out.println(prob.dietPlanPerformance(new int[]{1, 2, 3, 4, 5}, 1, 3, 3)); // 0
        System.out.println(prob.dietPlanPerformance(new int[]{3, 2}, 2, 0, 1)); // 1
        System.out.println(prob.dietPlanPerformance(new int[]{6, 5, 0, 0}, 2, 1, 5)); // 0
    }
}
