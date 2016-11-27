package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/can-i-win/
 */
public class Problem464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        int sum = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            sum += i;
        }
        if (sum < desiredTotal) {
            return false;
        }
        int[] nums = new int[maxChoosableInteger + 1];
        return canIWin(nums, desiredTotal, 0, Player.P2, new HashMap<>()) == Player.P1;
    }

    private enum Player {
        P1, P2
    }

    private static Player canIWin(int[] nums, int desired, int accu, Player player,
                                  Map<String, Player> memo) {
        if (accu >= desired) {
            return player;
        }
        // TODO: the memo isn't optimized
        String key = Arrays.toString(nums);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Player win = player;
        for (int num = 1; num < nums.length; num++) {
            if (nums[num] == 1) {
                continue;
            }
            nums[num] = 1;
            Player nextPlayer = (player == Player.P1) ? Player.P2 : Player.P1;
            if (player == Player.P1) {
                win = canIWin(nums, desired, accu + num, nextPlayer, memo);
                if (win == Player.P2) {
                    nums[num] = 0;
                    break;
                }
            } else if (player == Player.P2) {
                win = canIWin(nums, desired, accu + num, nextPlayer, memo);
                if (win == Player.P1) {
                    nums[num] = 0;
                    break;
                }
            }
            nums[num] = 0;
        }
        memo.put(key, win);
        return win;
    }

    public static void main(String[] args) {
        Problem464 prob = new Problem464();
//        System.out.println(prob.canIWin(10, 11)); // false
//        System.out.println(prob.canIWin(4, 6)); // true
//        System.out.println(prob.canIWin(10, 100)); // false
//        System.out.println(prob.canIWin(10, 55)); // false
//        System.out.println(prob.canIWin(6, 20)); // false
//        System.out.println(prob.canIWin(6, 15)); // true
//        System.out.println(prob.canIWin(6, 10)); // true
//        System.out.println(prob.canIWin(5, 12)); // true
//        System.out.println(prob.canIWin(5, 15)); // true
//        System.out.println(prob.canIWin(10, 0)); // true
//        System.out.println(prob.canIWin(18, 79)); // true
//        System.out.println(prob.canIWin(20, 200)); // false
//        System.out.println(prob.canIWin(11, 25)); // true
//        System.out.println(prob.canIWin(18, 79)); // true
//        System.out.println(prob.canIWin(10, 40)); // false
//        System.out.println(prob.canIWin(20, 54)); // true
//        System.out.println(prob.canIWin(20, 210)); // false
//        System.out.println(prob.canIWin(10, 0)); // true
        System.out.println(prob.canIWin(5, 50)); // true
    }
}
