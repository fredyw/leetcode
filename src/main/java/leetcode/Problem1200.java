package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-absolute-difference/
 */
public class Problem1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            min = Math.min(min, diff);
            if (!map.containsKey(diff)) {
                map.put(diff, new ArrayList<>());
            }
            map.get(diff).add(Arrays.asList(arr[i - 1], arr[i]));
        }
        return map.get(min);
    }

    public static void main(String[] args) {
        Problem1200 prob = new Problem1200();
        System.out.println(prob.minimumAbsDifference(new int[]{4,2,1,3})); // [[1,2],[2,3],[3,4]]
        System.out.println(prob.minimumAbsDifference(new int[]{1,3,6,10,15})); // [[1,3]]
        System.out.println(prob.minimumAbsDifference(new int[]{3,8,-10,23,19,-4,-14,27})); // [[-14,-10],[19,23],[23,27]]
    }
}
