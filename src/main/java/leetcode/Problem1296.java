package leetcode;

/**
 * https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */
public class Problem1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1296 prob = new Problem1296();
        System.out.println(prob.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4)); // true
        System.out.println(prob.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3)); // true
        System.out.println(prob.isPossibleDivide(new int[]{3,3,2,2,1,1}, 3)); // true
        System.out.println(prob.isPossibleDivide(new int[]{1,2,3,4}, 3)); // false
    }
}
