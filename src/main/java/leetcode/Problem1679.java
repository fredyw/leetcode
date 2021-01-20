package leetcode;

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
public class Problem1679 {
    public int maxOperations(int[] nums, int k) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1679 prob = new Problem1679();
        System.out.println(prob.maxOperations(new int[]{1,2,3,4}, 5)); // 2
        System.out.println(prob.maxOperations(new int[]{3,1,3,4,3}, 6)); // 1
    }
}
