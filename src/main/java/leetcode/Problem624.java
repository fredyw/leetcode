package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/maximum-distance-in-arrays/
 */
public class Problem624 {
    public int maxDistance(List<List<Integer>> arrays) {
        List<Group> min = new ArrayList<>();
        List<Group> max = new ArrayList<>();
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            if (array.size() >= 2) {
                min.add(new Group(i, array.get(0)));
                max.add(new Group(i, array.get(array.size() - 1)));
            } else if (array.size() == 1) {
                min.add(new Group(i, array.get(0)));
                max.add(new Group(i, array.get(0)));
            }
        }
        int result = 0;
        Collections.sort(min, (a, b) -> Integer.compare(a.value, b.value));
        Collections.sort(max, (a, b) -> Integer.compare(b.value, a.value));

        Group minGroup1 = min.get(0);
        Group maxGroup1 = max.get(0);
        if (minGroup1.group == maxGroup1.group) {
            Group minGroup2 = min.get(1);
            Group maxGroup2 = max.get(1);
            result = Math.max(result, maxGroup1.value - minGroup2.value);
            result = Math.max(result, maxGroup2.value - minGroup1.value);
            return result;
        }
        return Math.abs(maxGroup1.value - minGroup1.value);
    }

    private static class Group {
        private final int group;
        private final int value;

        public Group(int group, int value) {
            this.group = group;
            this.value = value;
        }
    }
}
