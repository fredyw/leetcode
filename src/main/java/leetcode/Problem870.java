package leetcode;

import java.util.Arrays;
import java.util.Comparator;

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
        Arrays.sort(b, Comparator.comparing(x -> x[1]));
        int right = A.length - 1;
        int left = 0;
        int j = B.length - 1;
        while (left <= right) {
            if (A[right] > b[j][1]) {
                answer[b[j][0]] = A[right];
                right--;
            } else {
                answer[b[j][0]] = A[left];
                left++;
            }
            j--;
        }
        return answer;
    }
}
