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
        System.out.println(prob.checkPowersOfThree(5)); // false
        System.out.println(prob.checkPowersOfThree(6)); // false
        System.out.println(prob.checkPowersOfThree(7)); // false
        System.out.println(prob.checkPowersOfThree(8)); // false
        System.out.println(prob.checkPowersOfThree(9)); // true
        System.out.println(prob.checkPowersOfThree(10)); // true
        System.out.println(prob.checkPowersOfThree(11)); // false
        System.out.println(prob.checkPowersOfThree(12)); // true
        System.out.println(prob.checkPowersOfThree(13)); // true
        System.out.println(prob.checkPowersOfThree(14)); // false
        System.out.println(prob.checkPowersOfThree(15)); // false
        System.out.println(prob.checkPowersOfThree(16)); // false
        System.out.println(prob.checkPowersOfThree(17)); // false
        System.out.println(prob.checkPowersOfThree(18)); // false
        System.out.println(prob.checkPowersOfThree(19)); // false
        System.out.println(prob.checkPowersOfThree(20)); // false
        System.out.println(prob.checkPowersOfThree(21)); // false
        System.out.println(prob.checkPowersOfThree(22)); // false
        System.out.println(prob.checkPowersOfThree(23)); // false
        System.out.println(prob.checkPowersOfThree(24)); // false
        System.out.println(prob.checkPowersOfThree(25)); // false
        System.out.println(prob.checkPowersOfThree(26)); // false
        System.out.println(prob.checkPowersOfThree(27)); // true
        System.out.println(prob.checkPowersOfThree(28)); // true
        System.out.println(prob.checkPowersOfThree(29)); // false
        System.out.println(prob.checkPowersOfThree(30)); // true
        System.out.println(prob.checkPowersOfThree(91)); // true
    }
}
