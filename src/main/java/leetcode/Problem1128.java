package leetcode;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */
public class Problem1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        int answer = 0;
        for (int i = 0; i < dominoes.length; i++) {
            for (int j = i + 1; j < dominoes.length; j++) {
                if ((dominoes[i][0] == dominoes[j][0] &&
                    dominoes[i][1] == dominoes[j][1]) ||
                    (dominoes[i][0] == dominoes[j][1] &&
                    dominoes[i][1] == dominoes[j][0])) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1128 prob = new Problem1128();
        System.out.println(prob.numEquivDominoPairs(new int[][]{
            {1, 2}, {2, 1}, {3, 4}, {5, 6}
        })); // 1
        System.out.println(prob.numEquivDominoPairs(new int[][]{
            {1, 2}, {2, 1}, {1, 2}
        })); // 3
        System.out.println(prob.numEquivDominoPairs(new int[][]{
            {1, 2}, {2, 1}, {1, 2}, {1, 2}
        })); // 6
        System.out.println(prob.numEquivDominoPairs(new int[][]{
            {1, 2}, {2, 1}, {1, 2}, {1, 2}, {1, 2}
        })); // 10
        System.out.println(prob.numEquivDominoPairs(new int[][]{
            {1, 2}, {2, 1}, {1, 2}, {1, 2}, {1, 2}, {1, 2}
        })); // 15
    }
}
