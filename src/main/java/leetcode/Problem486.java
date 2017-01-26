package leetcode;

/**
 * https://leetcode.com/problems/predict-the-winner/
 */
public class Problem486 {
    public boolean PredictTheWinner(int[] nums) {
        PlayerSum ps = predict(nums, 0, nums.length - 1, Player.P2);
        System.out.println(ps.player + " " + ps.sum);
        return false;
    }

    private static class PlayerSum {
        private final Player player;
        private final int sum;

        public PlayerSum(Player player, int sum) {
            this.player = player;
            this.sum = sum;
        }
    }

    private static PlayerSum predict(int[] nums, int start, int end, Player p) {
        if (start == end) {
            return new PlayerSum(p, 0);
        }
        Player nextPlayer = (p == Player.P1) ? Player.P2 : Player.P1;
        PlayerSum ps1 = predict(nums, start + 1, end, nextPlayer);
        PlayerSum ps2 = predict(nums, start, end - 1, nextPlayer);

        int a = nums[start] + Math.min(ps1.sum, ps2.sum);
        int b = nums[end] + Math.min(ps1.sum, ps2.sum);
        int max = Math.max(a, b);
        // TODO
        return null;
    }

    private enum Player {
        P1, P2
    }

    public static void main(String[] args) {
        Problem486 prob = new Problem486();
        System.out.println(prob.PredictTheWinner(new int[]{1, 5, 2})); // false
//        System.out.println(prob.PredictTheWinner(new int[]{1, 5, 233, 7})); // true
    }
}
