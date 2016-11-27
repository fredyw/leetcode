package leetcode;

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
        return canIWin(0, maxChoosableInteger, desiredTotal, 0, Player.P2,
            new HashMap<>()) == Player.P1;
    }

    private enum Player {
        P1, P2
    }

    private static Player canIWin(int bits, int max, int desired, int accu,
                                  Player player, Map<Integer, Player> memo) {
        if (accu >= desired) {
            return player;
        }
        if (memo.containsKey(bits)) {
            return memo.get(bits);
        }
        Player win = player;
        for (int num = 0; num < max; num++) {
            if ((bits & (1 << num)) == (1 << num)) {
                continue;
            }
            bits |= 1 << num;
            Player nextPlayer = (player == Player.P1) ? Player.P2 : Player.P1;
            if (player == Player.P1) {
                win = canIWin(bits, max, desired, accu + num + 1, nextPlayer, memo);
                if (win == Player.P2) {
                    bits &= ~(1 << num);
                    break;
                }
            } else if (player == Player.P2) {
                win = canIWin(bits, max, desired, accu + num + 1, nextPlayer, memo);
                if (win == Player.P1) {
                    bits &= ~(1 << num);
                    break;
                }
            }
            bits &= ~(1 << num);
        }
        memo.put(bits, win);
        return win;
    }
}
