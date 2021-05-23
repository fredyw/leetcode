package leetcode;

/**
 * https://leetcode.com/problems/longer-contiguous-segments-of-ones-than-zeros/
 */
public class Problem1869 {
    public boolean checkZeroOnes(String s) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1869 prob = new Problem1869();
        System.out.println(prob.checkZeroOnes("1101")); // true
        System.out.println(prob.checkZeroOnes("111000")); // false
        System.out.println(prob.checkZeroOnes("110100010")); // false
    }
}
