package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/
 */
public class Problem1887 {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> Integer.compare(b, a));
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int answer = 0;
        while (map.size() > 1) {
            Map.Entry<Integer, Integer> largestEntry = map.pollFirstEntry();
            Map.Entry<Integer, Integer> nextLargest = map.firstEntry();
            map.put(nextLargest.getKey(), nextLargest.getValue() + largestEntry.getValue());
            answer += largestEntry.getValue();
        }
        return answer;
    }
}
