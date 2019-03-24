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
        int tmpSum = 0;
        for (int i = 0; i < A.length; i++) {
            tmpSum += A[i];
            int rest = sum - tmpSum;
            if (rest % 2 == 0 && rest / 2 == tmpSum) {
                int s = 0;
                for (int j = i + 1; j < A.length; j++) {
                    s += A[j];
                    if (s == tmpSum && rest - s == tmpSum) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
