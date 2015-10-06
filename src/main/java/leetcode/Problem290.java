package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        int i = 0;
        for (char c : pattern.toCharArray()) {
            String s = Character.toString(c);
            if (!map.containsKey(s)) {
                map.put(s, i);
                list1.add(i);
            } else {
                list1.add(map.get(s));
            }
            i++;
        }
        map.clear();
        i = 0;
        List<Integer> list2 = new ArrayList<>();
        for (String s : str.split(" ")) {
            if (!map.containsKey(s)) {
                map.put(s, i);
                list2.add(i);
            } else {
                list2.add(map.get(s));
            }
            i++;
        }
        return list1.equals(list2);
    }
}
