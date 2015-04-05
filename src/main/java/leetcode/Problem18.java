package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/4sum/
 */
public class Problem18 {
    private static class Indices {
        int i;
        int j;
        
        public Indices(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num.length < 4) {
            return result;
        }
        Arrays.sort(num);
        Map<Integer, List<Indices>> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (!map.containsKey(num[i] + num[j])) {
                    map.put(num[i] + num[j], new ArrayList<>());
                }
                map.get(num[i] + num[j]).add(new Indices(i, j));
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = i+1; j < num.length; j++) {
                int expected = target - (num[i] + num[j]);
                if (map.containsKey(expected)) {
                    List<Indices> indices = map.get(expected);
                    for (Indices idx : indices) {
                        if (i == idx.i || i == idx.j || j == idx.i || j == idx.j) {
                            continue;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[idx.i]);
                        list.add(num[idx.j]);
                        Collections.sort(list);
                        String str = list.toString();
                        if (!set.contains(str)) {
                            set.add(str);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }
}
