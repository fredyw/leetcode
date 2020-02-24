package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class Problem1356 {
    public int[] sortByBits(int[] arr) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1356 prob = new Problem1356();
        System.out.println(Arrays.toString(prob.sortByBits(new int[]{0,1,2,3,4,5,6,7,8}))); // [0,1,2,4,8,3,5,6,7]
        System.out.println(Arrays.toString(prob.sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1}))); // [1,2,4,8,16,32,64,128,256,512,1024]
        System.out.println(Arrays.toString(prob.sortByBits(new int[]{10000,10000}))); // [10000,10000]
        System.out.println(Arrays.toString(prob.sortByBits(new int[]{2,3,5,7,11,13,17,19}))); // [2,3,5,17,7,11,13,19]
        System.out.println(Arrays.toString(prob.sortByBits(new int[]{10, 100, 1000, 10000}))); // [10,100,10000,1000]
    }
}
