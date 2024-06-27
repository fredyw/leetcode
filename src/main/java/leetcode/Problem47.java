package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations-ii/
 */
public class Problem47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> permutations = new HashSet<>();
        permutations(nums, 0, permutations);
        return new ArrayList<>(permutations);
    }

    private void permutations(int[] nums, int index, Set<List<Integer>> permutations) {
        permutations.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permutations(nums, index + 1, permutations);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Problem47 prob = new Problem47();
        System.out.println(prob.permuteUnique(new int[]{1, 1, 2})); // [[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(prob.permuteUnique(new int[]{1, 2, 3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
    }
}
