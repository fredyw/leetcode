package leetcode;

/**
 * https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/
 */
public class Problem1780 {
    public boolean checkPowersOfThree(int n) {
        long sum = 0;
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1780 prob = new Problem1780();
        System.out.println(prob.checkPowersOfThree(1)); // false
        System.out.println(prob.checkPowersOfThree(2)); // false
        System.out.println(prob.checkPowersOfThree(3)); // true
        System.out.println(prob.checkPowersOfThree(4)); // true
        System.out.println(prob.checkPowersOfThree(12)); // true
        System.out.println(prob.checkPowersOfThree(21)); // false
        System.out.println(prob.checkPowersOfThree(30)); // true
        System.out.println(prob.checkPowersOfThree(91)); // true
    }
}
