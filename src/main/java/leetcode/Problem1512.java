package leetcode;

/**
 * https://leetcode.com/problems/number-of-good-pairs/
 */
public class Problem1512 {
    public int numIdenticalPairs(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1512 prob = new Problem1512();
        System.out.println(prob.numIdenticalPairs(new int[]{1,2,3,1,1,3})); // 4
        System.out.println(prob.numIdenticalPairs(new int[]{1,1,1,1})); // 6
        System.out.println(prob.numIdenticalPairs(new int[]{1,2,3})); // 0
    }
}
