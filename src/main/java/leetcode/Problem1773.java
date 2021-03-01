package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-items-matching-a-rule/
 */
public class Problem1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> typeCount = new HashMap<>();
        Map<String, Integer> colorCount = new HashMap<>();
        Map<String, Integer> nameCount = new HashMap<>();
        for (List<String> item : items) {
            typeCount.put(item.get(0), typeCount.getOrDefault(item.get(0), 0) + 1);
            colorCount.put(item.get(1), colorCount.getOrDefault(item.get(1), 0) + 1);
            nameCount.put(item.get(2), nameCount.getOrDefault(item.get(2), 0) + 1);
        }
        if (ruleKey.equals("type")) {
            return typeCount.getOrDefault(ruleValue, 0);
        } else if (ruleKey.equals("color")) {
            return colorCount.getOrDefault(ruleValue, 0);
        }
        return nameCount.getOrDefault(ruleValue, 0);
    }
}
