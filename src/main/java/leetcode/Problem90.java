package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 */
public class Problem90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        return result;
    }
    
    public static void main(String[] args) {
        Problem90 prob = new Problem90();
        for (List<Integer> list : prob.subsetsWithDup(new int[]{1, 2, 2})) {
            System.out.println(list);
        }
    }
}
