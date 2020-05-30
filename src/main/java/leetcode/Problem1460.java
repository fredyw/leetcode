package leetcode;

/**
 * https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class Problem1460 {
    public boolean canBeEqual(int[] target, int[] arr) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1460 prob = new Problem1460();
        System.out.println(prob.canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3})); // true
        System.out.println(prob.canBeEqual(new int[]{7}, new int[]{7})); // true
        System.out.println(prob.canBeEqual(new int[]{1,12}, new int[]{12,1})); // true
        System.out.println(prob.canBeEqual(new int[]{3,7,9}, new int[]{3,7,11})); // false
        System.out.println(prob.canBeEqual(new int[]{1,1,1,1,1}, new int[]{1,1,1,1,1})); // true
    }
}
