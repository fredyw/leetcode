package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/can-i-win/
 */
public class Problem464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // TODO
        Set<Integer> nums = new TreeSet<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            nums.add(i);
        }
        return canIWin(nums, desiredTotal, 0, true, new HashMap<>());
    }

    private static boolean canIWin(Set<Integer> nums, int desired, int accu, boolean player1,
                                   Map<String, Boolean> memo) {
        if (accu >= desired) {
            if (!player1) {
                return true;
            }
            return false;
        }
        String key = accu + "|" + player1;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        boolean win = (player1) ? false : true;
        for (int num : nums) {
            Set<Integer> newNums = new HashSet<>(nums);
            newNums.remove(num);
            if (player1) {
                win |= canIWin(newNums, desired, accu + num, !player1, memo);
            } else {
                win &= canIWin(newNums, desired, accu + num, !player1, memo);
            }
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
        System.out.println(prob.canIWin(5, 12)); // true
//        System.out.println(prob.canIWin(5, 15)); // true
//        System.out.println(prob.canIWin(20, 200)); // false
    }
}
