package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/largest-values-from-labels/
 */
public class Problem1090 {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map</*value*/ Integer, /*labels*/ List<Integer>> valueLabels = new HashMap<>();
        for (int i = 0; i < labels.length; i++) {
            if (!valueLabels.containsKey(values[i])) {
                valueLabels.put(values[i], new ArrayList<>());
            }
            valueLabels.get(values[i]).add(labels[i]);
        }
        int answer = 0;
        Arrays.sort(values);
        int size = 0;
        Map</*label*/ Integer, /*count*/ Integer> labelCounts = new HashMap<>();
        outer:
        for (int i = values.length - 1; i >= 0; i--) {
            if (size == num_wanted) {
                break;
            }
            List<Integer> labelList = valueLabels.get(values[i]);
            Iterator<Integer> iterator = labelList.iterator();
            while (iterator.hasNext()) {
                int label = iterator.next();
                if (size == num_wanted) {
                    break outer;
                }
                Integer count = labelCounts.getOrDefault(label, 0);
                if (count < use_limit) {
                    answer += values[i];
                    labelCounts.put(label, count + 1);
                    iterator.remove();
                    size++;
                }
            }
        }
        return answer;
    }
}
