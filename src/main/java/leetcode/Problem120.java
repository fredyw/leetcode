package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 */
public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> result = new ArrayList<>();
        minimumTotal(triangle, 0, 0, 0, result);
        return Collections.min(result);
    }
    
    private void minimumTotal(List<List<Integer>> triangle, int idx1, int idx2,
        int sum, List<Integer> result) {
        if (idx1 == triangle.size()) {
            result.add(sum);
            return;
        }
        if (idx1 < triangle.size()) {
            if (idx2 < triangle.get(idx1).size()) {
                minimumTotal(triangle, idx1+1, idx2,
                    triangle.get(idx1).get(idx2)+sum, result);
            }
            if (idx2+1 < triangle.get(idx1).size()) {
                minimumTotal(triangle, idx1+1, idx2+1,
                    triangle.get(idx1).get(idx2+1)+sum, result);
            }
        }
    }
    
    public static void main(String[] args) {
        Problem120 prob = new Problem120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, -3));
        System.out.println(prob.minimumTotal(triangle));

        triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println(prob.minimumTotal(triangle));
    }
}