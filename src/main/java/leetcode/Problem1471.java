package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-k-strongest-values-in-an-array/
 */
public class Problem1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) / 2];
        int[] sorted = Arrays.stream(arr)
            .boxed()
            .sorted((a, b) -> {
                int i = Math.abs(a - m);
                int j = Math.abs(b - m);
                int cmp = Integer.compare(j, i);
                if (cmp == 0) {
                    return Integer.compare(b, a);
                }
                return cmp;
            })
            .mapToInt(a -> a).toArray();
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = sorted[i];
        }
        return answer;
    }
}
