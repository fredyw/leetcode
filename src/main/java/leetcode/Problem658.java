package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class Problem658 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int idx = Collections.binarySearch(arr, x);
        if (idx < 0) {
            idx = (-idx) - 1;
        }
        int left = idx - 1;
        int right = idx;
        while (k > 0) {
            int diff1 = Integer.MAX_VALUE;
            if (left >= 0) {
                diff1 = x - arr.get(left);
            }
            int diff2 = Integer.MAX_VALUE;
            if (right < arr.size()) {
                diff2 = arr.get(right) - x;
            }
            if (diff1 <= diff2) {
                left--;
            } else {
                right++;
            }
            k--;
        }
        left++;
        return arr.subList(left, right);
    }

    public static void main(String[] args) {
        Problem658 prob = new Problem658();
        System.out.println(prob.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 4, 3)); // [1,2,3,4]
        System.out.println(prob.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 4, -1)); // [1,2,3,4]
        System.out.println(prob.findClosestElements(Arrays.asList(10, 20, 30, 31, 35), 4, 30)); // [20,30,31,35]
        System.out.println(prob.findClosestElements(Arrays.asList(10, 20, 30, 32, 35), 4, 31)); // [20,30,32,35]
        System.out.println(prob.findClosestElements(Arrays.asList(10, 20, 30, 32, 100), 4, 31)); // [10,20,30,32]
        System.out.println(prob.findClosestElements(Arrays.asList(10, 20, 30, 100, 200), 3, 31)); // [10,20,30]
        System.out.println(prob.findClosestElements(Arrays.asList(10, 20, 30, 35, 36, 37), 3, 31)); // [30,35,36]
    }
}
