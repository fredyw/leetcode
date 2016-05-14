package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class Problem128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numToGroupMap = new HashMap<>();
        Map<Integer, Set<Integer>> groupToNumsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int prevNum = num - 1;
            int nextNum = num + 1;

            if (numToGroupMap.containsKey(num)) {
                continue;
            }
            numToGroupMap.put(num, i);
            if (groupToNumsMap.containsKey(i)) {
                groupToNumsMap.get(i).add(num);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                groupToNumsMap.put(i, set);
            }
            if (numToGroupMap.containsKey(prevNum)) {
                link(numToGroupMap, groupToNumsMap, num, prevNum);
            }
            if (numToGroupMap.containsKey(nextNum)) {
                link(numToGroupMap, groupToNumsMap, num, nextNum);
            }
        }
        int max = 0;
        for (Set<Integer> set : groupToNumsMap.values()) {
            max = Math.max(max, set.size());
        }
        return max;
    }

    private void link(Map<Integer, Integer> numToGroupMap,
                      Map<Integer, Set<Integer>> groupToNumsMap,
                      int num,
                      int consNum) {
        int group = numToGroupMap.get(num);
        int consGroup = numToGroupMap.get(consNum);
        Set<Integer> consSet = groupToNumsMap.get(consGroup);
        consSet.add(num);
        Set<Integer> set = groupToNumsMap.get(group);
        consSet.addAll(set);
        for (int n : set) {
            numToGroupMap.put(n, consGroup);
        }
        groupToNumsMap.remove(group);
    }
}
