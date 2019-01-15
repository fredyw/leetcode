package leetcode;

/**
 * https://leetcode.com/problems/possible-bipartition/
 */
public class Problem886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        // TODO
        return false;
    }

    public static void main(String[] args) {
        Problem886 prob = new Problem886();
        System.out.println(prob.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}})); // true
        System.out.println(prob.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}})); // false
        System.out.println(prob.possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}})); // false
    }
}
