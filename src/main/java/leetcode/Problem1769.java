package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class Problem1769 {
    public int[] minOperations(String boxes) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1769 prob = new Problem1769();
        System.out.println(Arrays.toString(prob.minOperations("110"))); // [1,1,3]
        System.out.println(Arrays.toString(prob.minOperations("001011"))); // [11,8,5,4,3,4]
    }
}
