package leetcode;

/**
 * https://leetcode.com/problems/maximum-ascending-subarray-sum/
 */
public class Problem1800 {
    public int maxAscendingSum(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1800 prob = new Problem1800();
        System.out.println(prob.maxAscendingSum(new int[]{10,20,30,5,10,50})); // 65
        System.out.println(prob.maxAscendingSum(new int[]{10,20,30,40,50})); // 150
        System.out.println(prob.maxAscendingSum(new int[]{12,17,15,13,10,11,12})); // 33
        System.out.println(prob.maxAscendingSum(new int[]{100,10,1})); // 100
    }
}
