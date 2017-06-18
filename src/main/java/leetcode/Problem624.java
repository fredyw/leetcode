package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 */
public class Problem624 {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if (array.size() >= 2) {
                min.add(array.get(0));
                max.add(array.get(array.size() - 1));
            } else if (array.size() == 1) {
                min.add(array.get(0));
                max.add(array.get(0));
            }
        }
        int result = 0;
        for (int i = 0; i < min.size(); i++) {
            for (int j = 0; j < min.size(); j++) {
                if (i == j) {
                    continue;
                }
                result = Math.max(result, Math.abs(max.get(i) - min.get(j)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem624 prob = new Problem624();
        System.out.println(prob.maxDistance(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 3)
        ))); // 4
        System.out.println(prob.maxDistance(Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 10)
        ))); // 9
        System.out.println(prob.maxDistance(Arrays.asList(
            Arrays.asList(2, 3, 4),
            Arrays.asList(4, 5),
            Arrays.asList(1, 2, 10)
        ))); // 8
    }
}
