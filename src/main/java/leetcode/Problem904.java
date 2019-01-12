package leetcode;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class Problem904 {
    public int totalFruit(int[] tree) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem904 prob = new Problem904();
        System.out.println(prob.totalFruit(new int[]{1, 2, 1})); // 3
        System.out.println(prob.totalFruit(new int[]{0, 1, 2, 2})); // 3
        System.out.println(prob.totalFruit(new int[]{1, 2, 3, 2, 2})); // 4
        System.out.println(prob.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4})); // 5
    }
}
