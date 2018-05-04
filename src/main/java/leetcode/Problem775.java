package leetcode;

/**
 * https://leetcode.com/problems/global-and-local-inversions/
 */
public class Problem775 {
    public boolean isIdealPermutation(int[] A) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem775 prob = new Problem775();
        System.out.println(prob.isIdealPermutation(new int[]{1, 0, 2})); // true
        System.out.println(prob.isIdealPermutation(new int[]{1, 2, 0})); // false
        System.out.println(prob.isIdealPermutation(new int[]{3, 2, 1, 0})); // false
        System.out.println(prob.isIdealPermutation(new int[]{0, 1, 2, 3})); // true
    }
}
