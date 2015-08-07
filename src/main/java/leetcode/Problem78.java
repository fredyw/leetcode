package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Problem78 {
    public List<List<Integer>> subsets(int[] nums) {
        return null;
    }
    
    public static void main(String[] args) {
        Problem78 prob = new Problem78();
        for (List<Integer> list : prob.subsets(new int[]{1, 2, 3})) {
            System.out.println(list);
        }
    }
}
