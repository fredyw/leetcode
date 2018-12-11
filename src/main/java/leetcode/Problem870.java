package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/advantage-shuffle/
 */
public class Problem870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] answer = new int[A.length];
        Arrays.sort(A);
        Integer[][] b = new Integer[B.length][2];
        for (int i = 0; i < B.length; i++) {
            b[i][0] = i; // the index
            b[i][1] = B[i]; // the value
        }
        int right = A.length - 1;
        int left = 0;
        int j = B.length - 1;
        while (left <= right) {
            if (A[right] > b[right][1]) {
                answer[b[j][0]] = A[right];
                right--;
                j--;
            } else {
                answer[b[j][0]] = A[left];
                left++;
                j--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem870 prob = new Problem870();
        System.out.println(Arrays.toString(prob.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}))); // [2,11,7,15]
        System.out.println(Arrays.toString(prob.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}))); // [24,32,8,12]
        System.out.println(Arrays.toString(prob.advantageCount(new int[]{12, 19, 29, 46}, new int[]{10, 20, 30, 40}))); // [12,29,46,19]
    }
}
