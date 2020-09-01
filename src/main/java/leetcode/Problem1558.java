package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-numbers-of-function-calls-to-make-target-array/
 */
public class Problem1558 {
    public int minOperations(int[] nums) {
        int answer = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();
        int val = (int) (Math.log(max) / Math.log(2));
        answer += val;
        answer += max % val;
        for (int num : nums) {
            if (num == 0) {
                answer--;
                continue;
            }
            if (num == 1 || num == max) {
                continue;
            }
            if (num % 2 != 0) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1558 prob = new Problem1558();
        System.out.println(prob.minOperations(new int[]{1,5})); // 5
        System.out.println(prob.minOperations(new int[]{2,2})); // 3
        System.out.println(prob.minOperations(new int[]{4,2,5})); // 6
        System.out.println(prob.minOperations(new int[]{3,2,2,4})); // 7
        System.out.println(prob.minOperations(new int[]{2,4,8,16})); // 8
        System.out.println(prob.minOperations(new int[]{2,3,10})); // 8
        System.out.println(prob.minOperations(new int[]{2,3,10,89})); // 15
    }
}
