package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/zuma-game/
 */
public class Problem488 {
    public int findMinStep(String board, String hand) {
        Map<Character, Integer> handMap = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (!handMap.containsKey(c)) {
                handMap.put(c, 1);
            } else {
                handMap.put(c, handMap.get(c) + 1);
            }
        }
        return findMinStep(board, handMap, 0);
    }

    private static int findMinStep(String board, Map<Character, Integer> hand, int idx) {
        if (idx >= board.length()) {
            return Integer.MAX_VALUE;
        }
        int i = idx;
        int j = i + 1;
        while (i < board.length() && j < board.length() && board.charAt(i) == board.charAt(j)) {
            j++;
        }
        int min = Integer.MAX_VALUE;
        if (j - i >= 2) {
            if (j - i == 2) {
                if (hand.containsKey(board.charAt(i))) {
                    int count = hand.get(board.charAt(i)) - 1;
                    if (count == 0) {
                        hand.remove(board.charAt(i));
                    } else {
                        hand.put(board.charAt(i), count);
                    }
                }
            }
            String left = board.substring(0, idx);
            String right = board.substring(j);
            int val = findMinStep(left + right, hand, 0);
            if (val == Integer.MIN_VALUE) {
                val = 0;
            }
            if (j - 1 == 2) {
                val =+ 1;
            }
            min = Math.min(min, val);
        }
        min = Math.min(min, findMinStep(board, hand, j));
        return min;
    }

    public static void main(String[] args) {
        Problem488 prob = new Problem488();
//        System.out.println(prob.findMinStep("WRRBBW", "RB")); // -1
//        System.out.println(prob.findMinStep("WWRRBBWW", "WRBRW")); // 2
        System.out.println(prob.findMinStep("WWRRBBWW", "WRBRW")); // 2
//        System.out.println(prob.findMinStep("G", "GGGGG")); // 2
//        System.out.println(prob.findMinStep("RBYYBBRRB", "YRBGB")); // 3
    }
}
