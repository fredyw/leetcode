package leetcode;

/**
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 */
public class Problem1020 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        int part = 0;
        for (int a : A) {
            part += a;
            if (part != 0 && sum % part == 0 && sum / part == 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem1020 prob = new Problem1020();
//        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1})); // true
//        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1})); // false
//        System.out.println(prob.canThreePartsEqualSum(new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4})); // true
//        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 0, 0, 0, 0})); // true
        System.out.println(prob.canThreePartsEqualSum(new int[]{0, 0, -3, 0, 3, 0, 0})); // true
    }
}
