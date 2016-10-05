package leetcode;

/**
 * https://leetcode.com/problems/utf-8-validation/
 */
public class Problem393 {
    public boolean validUtf8(int[] data) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem393 prob = new Problem393();
        System.out.println(prob.validUtf8(new int[]{197, 130, 1})); // true
        System.out.println(prob.validUtf8(new int[]{235, 140, 4})); // false
    }
}
