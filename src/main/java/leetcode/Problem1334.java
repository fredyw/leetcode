package leetcode;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class Problem1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1334 prob = new Problem1334();
        System.out.println(prob.findTheCity(4, new int[][]{
            {0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1},
        }, 4)); // 3
        System.out.println(prob.findTheCity(4, new int[][]{
            {0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1},
        }, 2)); // 0
    }
}
