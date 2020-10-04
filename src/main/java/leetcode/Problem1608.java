package leetcode;

/**
 * https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
 */
public class Problem1608 {
    public int specialArray(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1608 prob = new Problem1608();
        System.out.println(prob.specialArray(new int[]{3, 5})); // 2
        System.out.println(prob.specialArray(new int[]{0, 0})); // -1
        System.out.println(prob.specialArray(new int[]{0, 4, 3, 0, 4})); // 3
        System.out.println(prob.specialArray(new int[]{3, 6, 7, 7, 0})); // -1
    }
}
