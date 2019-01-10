package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/
 */
public class Problem969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> answer = new ArrayList<>();
        int right = A.length - 1;
        while (right >= 0) {
            int max = 0;
            int idx = -1;
            for (int j = 0; j <= right; j++) {
                if (max < A[j]) {
                    max = A[j];
                    idx = j;
                }
            }
            reverse(A, 0, idx);
            answer.add(idx + 1);
            reverse(A, 0, right);
            answer.add(right + 1);
            right--;
        }
        return answer;
    }

    private static void reverse(int[] a, int i, int j) {
        for (int x = i, y = j; x < y; x++, y--) {
            int tmp = a[x];
            a[x] = a[y];
            a[y] = tmp;
        }
    }
}
