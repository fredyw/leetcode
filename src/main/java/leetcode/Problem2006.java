package leetcode;

/**
 * https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class Problem2006 {
    public int countKDifference(int[] nums, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem2006 prob = new Problem2006();
        System.out.println(prob.countKDifference(new int[]{1,2,2,1}, 1)); // 4
        System.out.println(prob.countKDifference(new int[]{1,3}, 3)); // 0
        System.out.println(prob.countKDifference(new int[]{3,2,1,5,4}, 2)); // 3
    }
}
