package leetcode;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class Problem65 {
    public boolean isNumber(String s) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem65 prob = new Problem65();
        System.out.println(prob.isNumber("0")); // true
        System.out.println(prob.isNumber(" 0.1")); // true
        System.out.println(prob.isNumber("abc")); // false
        System.out.println(prob.isNumber("1 a")); // false
        System.out.println(prob.isNumber("2e10")); // true
    }
}
