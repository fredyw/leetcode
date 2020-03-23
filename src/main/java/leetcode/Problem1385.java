package leetcode;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/find-the-distance-value-between-two-arrays/
 */
public class Problem1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int a : arr2) {
            set.add(a);
        }
        int answer = 0;
        for (int n : arr1) {
            Integer higher = set.ceiling(n);
            Integer lower = set.floor(n);
            int diff;
            if (higher == null) {
                diff = Math.abs(lower - n);
            } else if (lower == null) {
                diff = Math.abs(higher - n);
            } else {
                diff = Math.min(higher - n, n - lower);
            }
            if (diff > d) {
                answer++;
            }
        }
        return answer;
    }
}
