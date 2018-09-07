package leetcode;

/**
 * https://leetcode.com/problems/monotonic-array/
 */
public class Problem896 {
    public boolean isMonotonic(int[] A) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem896 prob = new Problem896();
        System.out.println(prob.isMonotonic(new int[]{1, 2, 2, 3})); // true
        System.out.println(prob.isMonotonic(new int[]{6, 5, 4, 4})); // true
        System.out.println(prob.isMonotonic(new int[]{1, 3, 2})); // false
        System.out.println(prob.isMonotonic(new int[]{1, 2, 4, 5})); // true
        System.out.println(prob.isMonotonic(new int[]{1, 1, 1})); // true
    }
}
