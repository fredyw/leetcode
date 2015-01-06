package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://oj.leetcode.com/problems/triangle/
 */
public class Problem120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int result = 0;
        int idx = 0;
        for (int i = 0; i < triangle.size(); i++) {
            if (i == 0) {
                result = triangle.get(i).get(idx);
            } else {
                int a = triangle.get(i).get(idx);
                int b = triangle.get(i).get(idx+1);
                if (a <= b) {
                    result += a;
                } else {
                    result += b;
                    idx = idx + 1;
                }
            }
        }
        return result;
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