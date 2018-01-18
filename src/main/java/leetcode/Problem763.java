package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/partition-labels/
 */
public class Problem763 {
    public List<Integer> partitionLabels(String S) {
        List<Map<Character, Integer>> list = new ArrayList<>();
        list.add(new HashMap<>());
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            for (int j = 0; j < list.size(); j++) {
                Map<Character, Integer> map = list.get(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    int size = list.size();
                    for (int k = size - 1; k >= j + 1; k--) {
                        Map<Character, Integer> map2 = list.get(k);
                        map2.forEach((key, value) -> {
                            if (map.containsKey(key)) {
                                map.put(key, map.get(key) + value);
                            }
                        });
                        list.remove(k);
                    }
                    break;
                } else {
                    Map<Character, Integer> newMap = new HashMap<>();
                    newMap.put(c, 1);
                    list.add(newMap);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map<Character, Integer> map : list) {
            int total = 0;
            for (int value : map.values()) {
                total += value;
            }
            result.add(total);
        }
        return result;
    }

    public static void main(String[] args) {
        Problem763 prob = new Problem763();
        System.out.println(prob.partitionLabels("ababcbacadefegdehijhklij")); // [9,7,8]
    }
}
