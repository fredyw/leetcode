package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */
public class Problem238 {
   public int[] productExceptSelf(int[] nums) {
       int totalWithoutZero = 1;
       int total = 1;
       int nZero = 0;
       for (int num : nums) {
           if (num != 0) {
               totalWithoutZero *= num;
           } else {
               nZero++;
           }
           total *= num;
       }
       int[] output = new int[nums.length];
       for (int i = 0; i < nums.length; i++) {
           if (nZero > 1) {
               output[i] = 0;
           } else if (nZero == 1) {
               if (nums[i] == 0) {
                   output[i] = totalWithoutZero;
               } else {
                   output[i] = 0;
               }
           } else {
               output[i] = total / nums[i];
           }
       }
       return output;
   }
   
   public static void main(String[] args) {
       Problem238 prob = new Problem238();
       System.out.println(Arrays.toString(prob.productExceptSelf(new int[]{1, 2, 3, 4}))); // [24, 12, 8, 6]
       System.out.println(Arrays.toString(prob.productExceptSelf(new int[]{0, 0}))); // [0, 0]
       System.out.println(Arrays.toString(prob.productExceptSelf(new int[]{0, 2, 3}))); // [6, 0, 0]
   }
}
