package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class Problem989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem989 prob = new Problem989();
        System.out.println(prob.addToArrayForm(new int[]{1, 2, 0, 0}, 34)); // [1,2,3,4]
        System.out.println(prob.addToArrayForm(new int[]{2, 7, 4}, 181)); // [4,5,5]
        System.out.println(prob.addToArrayForm(new int[]{2, 1, 5}, 806)); // [1,0,2,1]
        System.out.println(prob.addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1)); // [1,0,0,0,0,0,0,0,0,0,0]
    }
}
