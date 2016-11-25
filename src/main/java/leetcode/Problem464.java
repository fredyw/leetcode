package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/can-i-win/
 */
public class Problem464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            nums.add(i);
        }
        Set<Integer> newNums = new HashSet<>(nums);
        for (int num : nums) {
            newNums.remove(num);
            Player win = canIWin(newNums, desiredTotal, num, Player.P1, new HashMap<>());
            if (win == Player.P1) {
                return true;
            }
            newNums.add(num);
        }
        return false;
    }

    private enum Player {
        P1, P2
    }

    private static Player canIWin(Set<Integer> nums, int desired, int accu, Player player,
                                  Map<String, Player> memo) {
        if (accu >= desired) {
            return player;
        }
        String key = accu + "|" + player + "|" + nums;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        Set<Integer> newNums = new HashSet<>(nums);
        Player win = player;
        for (int num : nums) {
            newNums.remove(num);
            Player nextPlayer = (player == Player.P1) ? Player.P2 : Player.P1;
            if (player == Player.P1) {
                win = canIWin(newNums, desired, accu + num, nextPlayer, memo);
                if (win == Player.P2) {
                    break;
                }
            } else if (player == Player.P2) {
                win = canIWin(newNums, desired, accu + num, nextPlayer, memo);
                if (win == Player.P1) {
                    break;
                }
            }
            newNums.add(num);
        }
        memo.put(key, win);
        return win;
    }

    private static class Debug {
        private final Player player;
        private final int number;

        public Debug(Player player, int number) {
            this.player = player;
            this.number = number;
        }

        @Override
        public String toString() {
            return "(" + player + ": " + number + ")";
        }
    }

    public static void main(String[] args) {
        Problem464 prob = new Problem464();
        System.out.println(prob.canIWin(10, 11)); // false
        System.out.println(prob.canIWin(4, 6)); // true
        System.out.println(prob.canIWin(10, 100)); // false
        System.out.println(prob.canIWin(10, 55)); // false
        System.out.println(prob.canIWin(6, 20)); // false
        System.out.println(prob.canIWin(6, 15)); // true
        System.out.println(prob.canIWin(6, 10)); // true
        System.out.println(prob.canIWin(5, 12)); // true
        System.out.println(prob.canIWin(5, 15)); // true
        System.out.println(prob.canIWin(10, 0)); // true
        System.out.println(prob.canIWin(18, 79)); // true
        System.out.println(prob.canIWin(20, 200)); // false
        System.out.println(prob.canIWin(11, 25)); // true
        System.out.println(prob.canIWin(18, 79)); // true
    }
}
