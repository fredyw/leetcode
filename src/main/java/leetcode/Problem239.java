package leetcode;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        int[] answer = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        int j = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == k) {
                answer[j] = map.firstKey();
                int c = map.get(nums[j]) - 1;
                if (c == 0) {
                    map.remove(nums[j]);
                } else {
                    map.put(nums[j], c);
                }
                j++;
                count--;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            count++;
        }
        answer[j] = map.firstKey();
        return answer;
    }
}
