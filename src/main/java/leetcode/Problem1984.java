package leetcode;

/**
 * https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class Problem1984 {
    public int minimumDifference(int[] nums, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1984 prob = new Problem1984();
        System.out.println(prob.minimumDifference(new int[]{90}, 1)); // 0
        System.out.println(prob.minimumDifference(new int[]{9,4,1,7}, 2)); // 2
        System.out.println(prob.minimumDifference(new int[]{9,4,1,7}, 3)); // 5
    }
}
