package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 */
public class Problem1963 {
    public int minSwaps(String s) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1963 prob = new Problem1963();
        System.out.println(prob.minSwaps("][][")); // 1
        System.out.println(prob.minSwaps("]]][[[")); // 2
        System.out.println(prob.minSwaps("[]")); // 0
    }
}
