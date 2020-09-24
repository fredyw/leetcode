package leetcode;

/**
 * https://leetcode.com/problems/count-unhappy-friends/
 */
public class Problem1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1583 prob = new Problem1583();
        System.out.println(prob.unhappyFriends(
            4,
            new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}},
            new int[][]{{0, 1}, {2, 3}})); // 2
        System.out.println(prob.unhappyFriends(
            2,
            new int[][]{{1}, {0}},
            new int[][]{{1, 0}})); // 0
        System.out.println(prob.unhappyFriends(
            4,
            new int[][]{{1, 3, 2}, {2, 3, 0}, {1, 3, 0}, {0, 2, 1}},
            new int[][]{{1, 3}, {0, 2}})); // 4
    }
}
