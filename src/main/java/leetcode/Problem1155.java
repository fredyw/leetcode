package leetcode;

/**
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class Problem1155 {
    public int numRollsToTarget(int d, int f, int target) {
        return (int) (numRollsToTarget(d, f, target, 0, new Long[/*dice*/ 31][/*sum*/ 1001]) % 1_000_000_007);
    }

    private static long numRollsToTarget(int dice, int faces, int target, int sum, Long[][] memo) {
        if (dice == 0) {
            return sum == target ? 1 : 0;
        }
        if (memo[dice][sum] != null) {
            return memo[dice][sum];
        }
        long count = 0;
        for (int i = 1; i <= faces; i++) {
            count += (numRollsToTarget(dice - 1, faces, target, sum + i, memo)) % 1_000_000_007;
        }
        memo[dice][sum] = count;
        return count;
    }
}
