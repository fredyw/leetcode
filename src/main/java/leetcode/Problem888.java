package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/fair-candy-swap/
 */
public class Problem888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        for (int a : A) {
            sumA += a;
        }
        int sumB = 0;
        for (int b : B) {
            sumB += b;
        }
        int[] result = new int[2];
        outer:
        for (int a : A) {
            for (int b : B) {
                if (sumA - a + b == sumB - b + a) {
                    result[0] = a;
                    result[1] = b;
                    break outer;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem888 prob = new Problem888();
        System.out.println(Arrays.toString(prob.fairCandySwap(
            new int[]{1, 1}, new int[]{2, 2}))); // [1,2]
        System.out.println(Arrays.toString(prob.fairCandySwap(
            new int[]{1, 2}, new int[]{2, 3}))); // [1,2]
        System.out.println(Arrays.toString(prob.fairCandySwap(
            new int[]{2}, new int[]{1, 3}))); // [2,3]
        System.out.println(Arrays.toString(prob.fairCandySwap(
            new int[]{1, 2, 5}, new int[]{2, 4}))); // [5,4]
    }
}
