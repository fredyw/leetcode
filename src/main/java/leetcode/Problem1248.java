package leetcode;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class Problem1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1248 prob = new Problem1248();
        System.out.println(prob.numberOfSubarrays(new int[]{1,1,2,1,1}, 3)); // 2
        System.out.println(prob.numberOfSubarrays(new int[]{2,4,6}, 1)); // 0
        System.out.println(prob.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2)); // 16
        System.out.println(prob.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2,1,2,2}, 2)); // 25
        System.out.println(prob.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2,1,2,2,2}, 2)); // 28
    }
}
