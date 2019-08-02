package leetcode;

/**
 * https://leetcode.com/problems/stone-game-ii/
 */
public class Problem1140 {
    public int stoneGameII(int[] piles) {
        return stoneGame(piles, 1, true, 0);
    }

    private static int stoneGame(int[] piles, int m, boolean alex, int index) {
        int answer = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int sum = 0;
            for (int j = index; j < index + i && j < piles.length; j++) {
                sum += piles[j];
                int value = stoneGame(piles, Math.max(i, m), !alex, j + 1);
                if (alex) {
                    value += sum;
                    answer = Math.max(answer,  value);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1140 prob = new Problem1140();
        System.out.println(prob.stoneGameII(new int[]{2, 7, 9, 4, 4})); // 10
//        System.out.println(prob.stoneGameII(new int[]{2, 3, 4})); // 5
//        System.out.println(prob.stoneGameII(new int[]{2})); // 2
//        System.out.println(prob.stoneGameII(new int[]{2, 3})); // 5
    }
}
