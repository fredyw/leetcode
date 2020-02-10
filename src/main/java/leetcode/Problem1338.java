package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reduce-array-size-to-the-half/
 */
public class Problem1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        int answer = 0;
        int size = arr.length;
        for (Map.Entry<Integer, Integer> e : entries) {
            size -= e.getValue();
            answer++;
            if (size <= arr.length / 2) {
                break;
            }
        }
        return answer;
    }
}
