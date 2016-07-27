package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/two-sum/
 */
public class Problem1 {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], new ArrayList<>());
            }
            map.get(numbers[i]).add(i);
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            int val = target - numbers[i];
            int j = Arrays.binarySearch(numbers, i, numbers.length, val);
            if (j < 0) {
                continue;
            } else {
                if (numbers[i] == numbers[j]) {
                    int a = map.get(numbers[i]).get(0) + 1;
                    int b = map.get(numbers[i]).get(1) + 1;
                    return (a < b) ? new int[]{a, b} : new int[]{b, a};
                } else {
                    int a = map.get(numbers[i]).get(0) + 1;
                    int b = map.get(numbers[j]).get(0) + 1;
                    return (a < b) ? new int[]{a, b} : new int[]{b, a};
                }
            }
        }
        return new int[]{};
    }
}
