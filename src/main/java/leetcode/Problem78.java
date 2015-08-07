package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());
        Collections.sort(numList);
        Set<List<Integer>> set = new HashSet<>();
        subsets(numList, set);
        result.addAll(set);
        result.add(numList);
        return result;
    }
    
    private void subsets(List<Integer> nums, Set<List<Integer>> set) {
        if (nums.size() == 0) {
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newList = createList(nums, i);
            if (set.contains(newList)) {
                continue;
            }
            set.add(newList);
            subsets(newList, set);
        }
    }
    
    private List<Integer> createList(List<Integer> nums, int idx) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (i != idx) {
                newList.add(nums.get(i));
            }
        }
        return newList;
    }
}
