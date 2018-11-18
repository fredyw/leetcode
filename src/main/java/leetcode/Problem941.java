package leetcode;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 */
public class Problem941 {
    public boolean validMountainArray(int[] A) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem941 prob = new Problem941();
        System.out.println(prob.validMountainArray(new int[]{2, 1})); // false
        System.out.println(prob.validMountainArray(new int[]{3, 5, 5})); // false
        System.out.println(prob.validMountainArray(new int[]{0, 3, 2, 1})); // true
        System.out.println(prob.validMountainArray(new int[]{0, 3, 2, 1, 5})); // false
        System.out.println(prob.validMountainArray(new int[]{3, 5, 5, 2})); // false
    }
}
