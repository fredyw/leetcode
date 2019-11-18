package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/shift-2d-grid/
 */
public class Problem1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;
        List<List<Integer>> answer = new ArrayList<>();
        // TODO:
        return answer;
    }

    public static void main(String[] args) {
        Problem1260 prob = new Problem1260();
        System.out.println(prob.shiftGrid(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }, 1)); // [[9,1,2],[3,4,5],[6,7,8]]
        System.out.println(prob.shiftGrid(new int[][]{
            {3, 8, 1, 9},
            {19, 7, 2, 5},
            {4, 6, 11, 10},
            {12, 0, 21, 13}
        }, 4)); // [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
        System.out.println(prob.shiftGrid(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }, 9)); // [[1,2,3],[4,5,6],[7,8,9]]
    }
}
