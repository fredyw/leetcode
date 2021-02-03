package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/
 */
public class Problem1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> pairs = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int[] pair : adjacentPairs) {
            pairs.putIfAbsent(pair[0], new ArrayList<>());
            pairs.get(pair[0]).add(pair[1]);
            pairs.putIfAbsent(pair[1], new ArrayList<>());
            pairs.getOrDefault(pair[1], new ArrayList<>()).add(pair[0]);
            set.add(pair[0]);
            set.add(pair[1]);
        }
        int first = 0;
        for (Map.Entry<Integer, List<Integer>> entry : pairs.entrySet()) {
            if (entry.getValue().size() == 1) {
                first = entry.getKey();
                break;
            }
        }
        int[] answer = new int[set.size()];
        answer[0] = first;
        Set<Integer> previous = new HashSet<>();
        previous.add(first);
        for (int i = 1; i < answer.length; i++) {
            int next = 0;
            for (int adj : pairs.get(answer[i - 1])) {
                if (!previous.contains(adj)) {
                    next = adj;
                    break;
                }
            }
            previous.add(next);
            answer[i] = next;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1743 prob = new Problem1743();
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {2,1},{3,4},{3,2}
        }))); // [1,2,3,4]
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {4,-2},{1,4},{-3,1}
        }))); // [-2,4,1,-3]
        System.out.println(Arrays.toString(prob.restoreArray(new int[][]{
            {100000,-100000}
        }))); // [100000,-100000]
    }
}
