package leetcode;

/**
 * https://leetcode.com/problems/coin-change-2/
 */
public class Problem518 {
    public int change(int amount, int[] coins) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem518 prob = new Problem518();
        System.out.println(prob.change(5, new int[]{1, 2, 5})); // 4
        System.out.println(prob.change(3, new int[]{2})); // 0
        System.out.println(prob.change(10, new int[]{10})); // 1
    }
}

