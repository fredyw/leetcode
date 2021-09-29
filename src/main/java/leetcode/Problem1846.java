package leetcode;

/**
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 */
public class Problem1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1846 prob = new Problem1846();
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{2,2,1,2,1})); // 2
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000})); // 3
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{100,100,100,1000})); // 4
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{1,1,1,1})); // 1
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{1,2,3,4,5})); // 5
        System.out.println(prob.maximumElementAfterDecrementingAndRearranging(new int[]{4,3,2,1})); // 4
    }
}
