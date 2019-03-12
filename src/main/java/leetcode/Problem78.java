package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private static void subsets(int[] nums, int index, List<Integer> accu, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(accu));
        for (int i = index; i < nums.length; i++) {
            accu.add(nums[i]);
            subsets(nums, i + 1, accu, answer);
            accu.remove(accu.size() - 1);

        }
    }
}
