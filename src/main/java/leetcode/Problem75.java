package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        // using counting sort
        int[] aux = new int[nums.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = nums[i];
        }
        System.out.println("Input: " + Arrays.toString(nums));
        int size = 3;
        int[] count = new int[size];
        for (int i = 0; i < aux.length; i++) {
            count[aux[i]] += 1;
        }
        System.out.println("Count: " + Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }
        System.out.println("Sum: " + Arrays.toString(count));
        for (int i = aux.length-1; i >= 0; i--) {
            int val = aux[i];
            count[val]--;
            int idx = count[val];
            nums[idx] = val;
        }
        System.out.println("Sorted: " + Arrays.toString(nums));
    }
    
    public static void main(String[] args) {
        Problem75 prob = new Problem75();
//        prob.sortColors(new int[]{2});
//        prob.sortColors(new int[]{3, 2, 1, 2, 3, 1});
//        prob.sortColors(new int[]{2, 27, 22, 8, 28, 1, 30, 8, 29, 28, 15, 16, 25, 28, 23, 16, 24, 23, 17, 11, 4, 2, 2, 22, 23, 8, 29, 16, 29, 28});
//        prob.sortColors(new int[]{1, 4, 1, 2, 7, 5, 2});
    }
}
