package leetcode;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class Problem1207 {
    public boolean uniqueOccurrences(int[] arr) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1207 prob = new Problem1207();
        System.out.println(prob.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})); // true
        System.out.println(prob.uniqueOccurrences(new int[]{1, 2})); // false
        System.out.println(prob.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0})); // true
    }
}
