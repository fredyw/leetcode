package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/array-transformation/
 */
public class Problem1243 {
    public List<Integer> transformArray(int[] arr) {
        while (true) {
            boolean found = false;
            int[] copy = Arrays.copyOf(arr, arr.length);
            for (int i = 1; i < arr.length - 1; i++) {
                if (copy[i - 1] < copy[i] && copy[i] > copy[i + 1]) {
                    found = true;
                    arr[i]--;
                } else if (copy[i - 1] > copy[i] && copy[i] < copy[i + 1]) {
                    found = true;
                    arr[i]++;
                }
            }
            if (!found) {
                break;
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int a : arr) {
            answer.add(a);
        }
        return answer;
    }
}
