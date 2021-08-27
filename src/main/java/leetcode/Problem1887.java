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
            map.put(nextLargest.getKey(), nextLargest.getValue() + 1);
            int largestEntryCount = largestEntry.getValue() - 1;
            if (largestEntryCount > 0) {
                map.put(largestEntry.getKey(), largestEntryCount);
            }
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1887 prob = new Problem1887();
        System.out.println(prob.reductionOperations(new int[]{5,1,3})); // 3
        System.out.println(prob.reductionOperations(new int[]{1,1,1})); // 0
        System.out.println(prob.reductionOperations(new int[]{1,1,2,2,3})); // 4
    }
}
