package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Problem39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // TODO: implement this
        return result;
    }
    
    public static void main(String[] args) {
        Problem39 prob = new Problem39();
        for (List<Integer> list : prob.combinationSum(new int[]{2, 3, 6, 7}, 7)) {
            System.out.println(list);
        }
    }
}
