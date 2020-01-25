package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array/
 */
public class Problem1331 {
    public int[] arrayRankTransform(int[] arr) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1331 prob = new Problem1331();
        System.out.println(Arrays.toString(prob.arrayRankTransform(new int[]{40,10,20,30}))); // [4,1,2,3]
        System.out.println(Arrays.toString(prob.arrayRankTransform(new int[]{100,100,100}))); // [1,1,1]
        System.out.println(Arrays.toString(prob.arrayRankTransform(new int[]{37,12,28,9,100,56,80,5,12}))); // [5,3,4,2,8,6,7,1,3]
    }
}
