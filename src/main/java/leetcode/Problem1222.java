package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/queens-that-can-attack-the-king/
 */
public class Problem1222 {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1222 prob = new Problem1222();
        System.out.println(prob.queensAttacktheKing(
            new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}},
            new int[]{0, 0}
        )); // [[0,1],[1,0],[3,3]]
        System.out.println(prob.queensAttacktheKing(
            new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}},
            new int[]{3, 3}
        )); // [[2,2],[3,4],[4,4]]
        System.out.println(prob.queensAttacktheKing(
            new int[][]{{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}},
            new int[]{3, 4}
        )); // [[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
    }
}
