package leetcode;

/**
 * https://leetcode.com/problems/three-divisors/
 */
public class Problem1952 {
    public boolean isThree(int n) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1952 prob = new Problem1952();
        System.out.println(prob.isThree(2)); // false
        System.out.println(prob.isThree(4)); // true
        System.out.println(prob.isThree(6)); // false
        System.out.println(prob.isThree(49)); // true
        System.out.println(prob.isThree(100)); // false
    }
}
