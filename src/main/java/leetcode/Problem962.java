package leetcode;

/**
 * https://leetcode.com/problems/maximum-width-ramp/
 */
public class Problem962 {
    public int maxWidthRamp(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = A.length - 1; j >= i; j--) {
                if (A[i] <= A[j]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem962 prob = new Problem962();
        System.out.println(prob.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5})); // 4
        System.out.println(prob.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1})); // 7
        System.out.println(prob.maxWidthRamp(new int[]{5, 4, 3, 2, 1})); // 0
    }
}
