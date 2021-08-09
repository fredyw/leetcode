package leetcode;

/**
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class Problem1780 {
    public boolean checkPowersOfThree(int n) {
        return checkPowersOfThree(n, 1);
    }

    private static boolean checkPowersOfThree(int n, int pow) {
        if (pow == n) {
            return true;
        }
        if (pow > n) {
            return false;
        }
        return checkPowersOfThree(n, pow * 3) || checkPowersOfThree(n - pow, pow * 3);
    }
}
