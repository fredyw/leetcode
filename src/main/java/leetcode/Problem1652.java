package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/defuse-the-bomb/
 */
public class Problem1652 {
    public int[] decrypt(int[] code, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1652 prob = new Problem1652();
        System.out.println(Arrays.toString(prob.decrypt(new int[]{5,7,1,4}, 3))); // [12,10,16,13]
        System.out.println(Arrays.toString(prob.decrypt(new int[]{1,2,3,4}, 0))); // [0,0,0,0]
        System.out.println(Arrays.toString(prob.decrypt(new int[]{2,4,9,3}, -2))); // [12,5,6,13]
    }
}
