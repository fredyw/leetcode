package leetcode;

/**
 * https://leetcode.com/problems/maximum-of-absolute-value-expression/
 */
public class Problem1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int size = arr1.length;
        int values[][] = new int[8][size];
        for (int i = 0; i < size; i++) {
            values[0][i] += arr1[i] + arr2[i] + i;
        }
        for (int i = 0; i < size; i++) {
            values[1][i] += arr1[i] + arr2[i] - i;
        }
        for (int i = 0; i < size; i++) {
            values[2][i] += arr1[i] - arr2[i] + i;
        }
        for (int i = 0; i < size; i++) {
            values[3][i] += arr1[i] - arr2[i] - i;
        }
        for (int i = 0; i < size; i++) {
            values[4][i] += -arr1[i] + arr2[i] + i;
        }
        for (int i = 0; i < size; i++) {
            values[5][i] += -arr1[i] + arr2[i] - i;
        }
        for (int i = 0; i < size; i++) {
            values[6][i] += -arr1[i] - arr2[i] + i;
        }
        for (int i = 0; i < size; i++) {
            values[7][i] += -arr1[i] - arr2[i] - i;
        }
        int answer = 0;
        for (int[] nums : values) {
            answer = Math.max(answer, getValue(nums));
        }
        return answer;
    }

    private static int getValue(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min;
    }
}
