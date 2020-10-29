package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/arithmetic-subarrays/
 */
public class Problem1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1630 prob = new Problem1630();
        System.out.println(prob.checkArithmeticSubarrays(
            new int[]{4,6,5,9,3,7}, new int[]{0,0,2}, new int[]{2,3,5})); // [true,false,true]
        System.out.println(prob.checkArithmeticSubarrays(
            new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10})); // [false,true,false,false,true,true]
    }
}
