package leetcode;

/**
 * https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
public class Problem1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1566 prob = new Problem1566();
        System.out.println(prob.containsPattern(new int[]{1,2,4,4,4,4}, 1, 3)); // true
        System.out.println(prob.containsPattern(new int[]{1,2,4,4,4,4}, 2, 2)); // true
        System.out.println(prob.containsPattern(new int[]{1,2,1,2,1,3}, 2, 3)); // false
        System.out.println(prob.containsPattern(new int[]{1,2,3,1,2}, 2, 2)); // false
        System.out.println(prob.containsPattern(new int[]{2,2,2,2}, 2, 3)); // false
    }
}
