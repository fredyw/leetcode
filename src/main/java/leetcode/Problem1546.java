package leetcode;

/**
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
 */
public class Problem1546 {
    public int maxNonOverlapping(int[] nums, int target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1546 prob = new Problem1546();
        System.out.println(prob.maxNonOverlapping(new int[]{1,1,1,1,1}, 2)); // 2
        System.out.println(prob.maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9}, 6)); // 2
        System.out.println(prob.maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,8}, 10)); // 3
        System.out.println(prob.maxNonOverlapping(new int[]{0,0,0}, 0)); // 3
    }
}
