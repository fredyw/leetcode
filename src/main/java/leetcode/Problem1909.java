package leetcode;

/**
 * https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
 */
public class Problem1909 {
    public boolean canBeIncreasing(int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1909 prob = new Problem1909();
        System.out.println(prob.canBeIncreasing(new int[]{1,2,10,5,7})); // true
        System.out.println(prob.canBeIncreasing(new int[]{2,3,1,2})); // false
        System.out.println(prob.canBeIncreasing(new int[]{1,1,1})); // false
        System.out.println(prob.canBeIncreasing(new int[]{1,2,3})); // true
    }
}
