package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
 */
public class Problem1317 {
    public int[] getNoZeroIntegers(int n) {
        int[] answer = new int[2];
        // TODO
        return answer;
    }

    public static void main(String[] args) {
        Problem1317 prob = new Problem1317();
        System.out.println(Arrays.toString(prob.getNoZeroIntegers(2))); // [1,1]
        System.out.println(Arrays.toString(prob.getNoZeroIntegers(11))); // [2,9]
        System.out.println(Arrays.toString(prob.getNoZeroIntegers(10000))); // [1,9999]
        System.out.println(Arrays.toString(prob.getNoZeroIntegers(69))); // [1,68]
        System.out.println(Arrays.toString(prob.getNoZeroIntegers(1010))); // [11,999]
    }
}
