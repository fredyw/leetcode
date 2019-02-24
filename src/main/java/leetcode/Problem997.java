package leetcode;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class Problem997 {
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N + 1];
        int[] trustees = new int[N + 1];
        for (int[] t : trust) {
            trusts[t[0]]++;
            trustees[t[1]]++;
        }
        int a = 0;
        int b = 0;
        for (int i = 1; i < trusts.length; i++) {
            if (trusts[i] == 0) {
                a = i;
            }
            if (trustees[i] == N - 1) {
                b = i;
            }
        }
        return a == b ? a : -1;
    }
}
