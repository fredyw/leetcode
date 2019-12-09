package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class Problem1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> answer = new ArrayList<>();
        for (int size : map.keySet()) {
            List<Integer> indexes = map.get(size);
            for (int i = 0; i < indexes.size(); i += size) {
                answer.add(indexes.subList(i, i + size));
            }
        }
        return answer;
    }
}
