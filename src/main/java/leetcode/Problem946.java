package leetcode;

/**
 * https://leetcode.com/problems/validate-stack-sequences/
 */
public class Problem946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem946 prob = new Problem946();
        System.out.println(prob.validateStackSequences(
            new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}
        )); // true
        System.out.println(prob.validateStackSequences(
            new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}
        )); // false
    }
}
