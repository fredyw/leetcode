package leetcode;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class Problem1155 {
    public int numRollsToTarget(int d, int f, int target) {
        for (int i = 0; i < d; i++) {
            for (int j = 1; j <= f; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem1155 prob = new Problem1155();
        System.out.println(prob.numRollsToTarget(1, 6, 3)); // 1
        System.out.println(prob.numRollsToTarget(2, 6, 7)); // 6
        System.out.println(prob.numRollsToTarget(2, 5, 10)); // 1
        System.out.println(prob.numRollsToTarget(1, 2, 3)); // 0
        System.out.println(prob.numRollsToTarget(30, 30, 500)); // 222616187
    }
}
