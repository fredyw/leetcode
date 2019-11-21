package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/circular-permutation-in-binary-representation/
 */
public class Problem1238 {
    public List<Integer> circularPermutation(int n, int start) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1238 prob = new Problem1238();
        System.out.println(prob.circularPermutation(2, 3)); // [3,2,0,1]
        System.out.println(prob.circularPermutation(3, 2)); // [2,6,7,5,4,0,1,3]
    }
}
