package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class Problem1509 {
    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int answer = Integer.MAX_VALUE;
        for (int i = 0, j = nums.length - 2; i < 3; i++, j++) {
            answer = Math.min(answer, nums[j - 1] - nums[i + 1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1509 prob = new Problem1509();
//        System.out.println(prob.minDifference(new int[]{5,3,2,4})); // 0
        System.out.println(prob.minDifference(new int[]{1,5,0,10,14})); // 1
//        System.out.println(prob.minDifference(new int[]{3,5,0,10,14})); // 2
//        System.out.println(prob.minDifference(new int[]{6,6,0,1,1,4,6})); // 2
//        System.out.println(prob.minDifference(new int[]{1,5,6,14,15})); // 1
//        System.out.println(prob.minDifference(new int[]{1})); // 0
//        System.out.println(prob.minDifference(new int[]{1,2})); // 0
//        System.out.println(prob.minDifference(new int[]{1,2})); // 0
//        System.out.println(prob.minDifference(new int[]{1,2,3})); // 0
//        System.out.println(prob.minDifference(new int[]{1,2,3,100})); // 0
//        System.out.println(prob.minDifference(new int[]{82,81,95,75,20})); // 1
//        System.out.println(prob.minDifference(new int[]{82,81,95,75,20,98})); // 7
//        System.out.println(prob.minDifference(new int[]{448,433,498,103,81,537,995,376,286,737,132,702,740,446,811,709,578,534,821,730,216,1,344,192,645})); // 718
    }
}
