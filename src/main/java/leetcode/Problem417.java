package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 */
public class Problem417 {
    public List<int[]> pacificAtlantic(int[][]matrix) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem417 prob = new Problem417();
        System.out.println(prob.pacificAtlantic(new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}}
        )); // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }
}
