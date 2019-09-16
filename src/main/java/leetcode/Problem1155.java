package leetcode;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class Problem1155 {
    public int numRollsToTarget(int d, int f, int target) {
        return numRollsToTarget(d, f, target, 0, new Integer[/*dice*/ 31][/*sum*/ 1001]) % 1_000_000_007;
    }

    private static int numRollsToTarget(int dice, int faces, int target, int sum, Integer[][] memo) {
        if (dice == 0) {
            return sum == target ? 1 : 0;
        }
        if (memo[dice][sum] != null) {
            return memo[dice][sum];
        }
        int count = 0;
        for (int i = 1; i <= faces; i++) {
            count += (numRollsToTarget(dice - 1, faces, target, sum + i, memo)) % 1_000_000_007;
        }
        memo[dice][sum] = count % 1_000_000_007;
        return count % 1_000_000_007;
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
