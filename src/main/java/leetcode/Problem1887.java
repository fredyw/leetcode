package leetcode;

/**
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 */
public class Problem1887 {
    public int reductionOperations(int[] nums) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1887 prob = new Problem1887();
        System.out.println(prob.reductionOperations(new int[]{5,1,3})); // 3
        System.out.println(prob.reductionOperations(new int[]{1,1,1})); // 0
        System.out.println(prob.reductionOperations(new int[]{1,1,2,2,3})); // 4
    }
}
