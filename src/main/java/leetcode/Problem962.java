package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/maximum-width-ramp/
 */
public class Problem962 {
    public int maxWidthRamp(int[] A) {
        Integer[] indexes = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, Comparator.comparingInt(index -> A[index]));
        int answer = 0;
        int minIndex = A.length;
        for (int index : indexes) {
            answer = Math.max(answer, index - minIndex);
            minIndex = Math.min(minIndex, index);
        }
        return answer;
    }
}
