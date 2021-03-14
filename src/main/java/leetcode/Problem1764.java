package leetcode;

/**
 * https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/
 */
public class Problem1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1764 prob = new Problem1764();
        System.out.println(prob.canChoose(new int[][]{
            {1,-1,-1},{3,-2,0}
        }, new int[]{1,-1,0,1,-1,-1,3,-2,0})); // true
        System.out.println(prob.canChoose(new int[][]{
            {10,-2},{1,2,3,4}
        }, new int[]{1,2,3,4,10,-2})); // false
        System.out.println(prob.canChoose(new int[][]{
            {1,2,3},{3,4}
        }, new int[]{7,7,1,2,3,4,7,7})); // false
    }
}
