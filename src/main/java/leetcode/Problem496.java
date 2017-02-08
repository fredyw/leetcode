package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class Problem496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int nextGreater = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    nextGreater = nums[j];
                    break;
                }
            }
            map.put(nums[i], nextGreater);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < findNums.length; i++) {
            list.add(map.get(findNums[i]));
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
