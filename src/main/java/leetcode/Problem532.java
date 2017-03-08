package leetcode;

/**
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */
public class Problem532 {
    public int findPairs(int[] nums, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem532 prob = new Problem532();
        System.out.println(prob.findPairs(new int[]{3, 1, 4, 1, 5}, 2)); // 2
        System.out.println(prob.findPairs(new int[]{1, 2, 3, 4, 5}, 1)); // 4
        System.out.println(prob.findPairs(new int[]{1, 3, 1, 5, 4}, 0)); // 1
    }
}
