package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/decode-xored-array/
 */
public class Problem1720 {
    public int[] decode(int[] encoded, int first) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1720 prob = new Problem1720();
        System.out.println(Arrays.toString(prob.decode(new int[]{1,2,3}, 1))); // [1,0,2,1]
        System.out.println(Arrays.toString(prob.decode(new int[]{6,2,7,3}, 4))); // [4,2,0,7,4]
    }
}
