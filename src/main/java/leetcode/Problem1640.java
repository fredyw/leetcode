package leetcode;

/**
 * https://leetcode.com/problems/check-array-formation-through-concatenation/
 */
public class Problem1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1640 prob = new Problem1640();
        System.out.println(prob.canFormArray(new int[]{85}, new int[][]{{85}})); // true
        System.out.println(prob.canFormArray(new int[]{15,88}, new int[][]{{88},{15}})); // true
        System.out.println(prob.canFormArray(new int[]{49,18,16}, new int[][]{{8516,18,49}})); // false
        System.out.println(prob.canFormArray(new int[]{91,4,64,78}, new int[][]{{78},{4,64},{91}})); // true
        System.out.println(prob.canFormArray(new int[]{1,3,5,7}, new int[][]{{2,4,6,8}})); // false
    }
}
