package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/closest-divisors/
 */
public class Problem1362 {
    public int[] closestDivisors(int num) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1362 prob = new Problem1362();
        System.out.println(Arrays.toString(prob.closestDivisors(8))); // [3,3]
        System.out.println(Arrays.toString(prob.closestDivisors(123))); // [5,25]
        System.out.println(Arrays.toString(prob.closestDivisors(999))); // [40,25]
    }
}
