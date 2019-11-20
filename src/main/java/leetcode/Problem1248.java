package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class Problem1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        int answer = 0;
        int count = 0;
        int index = 0;
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                count++;
                indexes.add(i);
            }
            if (count > k) {
                int left = index - 1 < 0 ? indexes.get(index) : indexes.get(index) - indexes.get(index - 1) - 1;
                int right = indexes.get(indexes.size() - 1) - indexes.get(indexes.size() - 2) - 1;
                index++;
                count--;
                answer += (1 + left + right + (left * right));
            }
        }
        if (count == k) {
            int left = index - 1 < 0 ? indexes.get(index) : indexes.get(index) - indexes.get(index - 1) - 1;
            int right = nums.length - indexes.get(indexes.size() - 1) - 1;
            answer += (1 + left + right + (left * right));
        }
        return answer;
    }
}
