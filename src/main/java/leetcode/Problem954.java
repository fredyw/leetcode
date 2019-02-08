package leetcode;

/**
 * https://leetcode.com/problems/array-of-doubled-pairs/
 */
public class Problem954 {
    public boolean canReorderDoubled(int[] A) {
        // TODO
        for (int i = 0; i < A.length / 2; i++) {
            System.out.println(i + ": " + A[2 * i + 1] + " --> " + (2 * A[2 * i]));
        }
        return false;
    }

    public static void main(String[] args) {
        Problem954 prob = new Problem954();
//        System.out.println(prob.canReorderDoubled(new int[]{3, 1, 3, 6})); // false
//        System.out.println(prob.canReorderDoubled(new int[]{2, 1, 2, 6})); // false
//        System.out.println(prob.canReorderDoubled(new int[]{4, -2, 2, -4})); // true
        System.out.println(prob.canReorderDoubled(new int[]{-2, -4, 2, 4})); // true
//        System.out.println(prob.canReorderDoubled(new int[]{1, 2, 4, 16, 8, 4})); // false
    }
}
