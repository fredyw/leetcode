package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/array-transformation/
 */
public class Problem1243 {
    public List<Integer> transformArray(int[] arr) {
        while (true) {
            boolean found = false;
            for (int i = 1; i < arr.length - 2; i++) {
                if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    found = true;
                    arr[i]--;
                } else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
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

    public static void main(String[] args) {
        Problem1243 prob = new Problem1243();
        System.out.println(prob.transformArray(new int[]{6,2,3,4})); // [6,3,3,4]
        System.out.println(prob.transformArray(new int[]{1,6,3,4,3,5})); // [1,4,4,4,4,5]
    }
}
