package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/duplicate-zeros/
 */
public class Problem1089 {
    public void duplicateZeros(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                answer.add(arr[i]);
            }
            answer.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = answer.get(i);
        }
    }
}
