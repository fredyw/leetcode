package leetcode;

/**
 * https://leetcode.com/problems/closest-subsequence-sum/
 */
public class Problem1755 {
    public int minAbsDifference(int[] nums, int goal) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1755 prob = new Problem1755();
        System.out.println(prob.minAbsDifference(new int[]{5,-7,3,5}, 6)); // 0
        System.out.println(prob.minAbsDifference(new int[]{7,-9,15,-2}, -5)); // 1
        System.out.println(prob.minAbsDifference(new int[]{1,2,3}, -7)); // 7
    }
}
