package leetcode;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class Problem997 {
    public int findJudge(int N, int[][] trust) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem997 prob = new Problem997();
        System.out.println(prob.findJudge(2, new int[][]{{1, 2}})); // 2
        System.out.println(prob.findJudge(2, new int[][]{{1, 3}, {2, 3}})); // 3
        System.out.println(prob.findJudge(2, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // -1
        System.out.println(prob.findJudge(2, new int[][]{{1, 2}, {2, 3}})); // -1
    }
}
