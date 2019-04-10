package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/group-anagrams/
 */
public class Problem49 {
    public List<List<String>> anagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if (!map.containsKey(sorted)) {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            } else {
                map.get(sorted).add(s);
            }
        }
        return map.values().stream()
            .map(e -> new ArrayList<>(e))
            .collect(Collectors.toList());
    }
}
