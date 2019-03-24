package leetcode;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class Problem1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem1020 prob = new Problem1020();
        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})); // true
        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1})); // fals
        System.out.println(prob.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4})); // true
    }
}
