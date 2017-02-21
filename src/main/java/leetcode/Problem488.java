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
        int result = findMinStep(board + ".", handMap);
        return (result == 6) ? -1 : result;
    }

    private static int findMinStep(String board, Map<Character, Integer> hand) {
        board = remove(board);
        if (board.equals(".")) {
            return 0;
        }
        int min = 6;
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(i) == board.charAt(j)) {
                continue;
            }
            int need = 3 - (j - i);
            if (hand.containsKey(board.charAt(i))) {
                int count = hand.get(board.charAt(i));
                if (count >= need && count - need >= 0) {
                    hand.put(board.charAt(i), count - need);
                    String newBoard = board.substring(0, i) + board.substring(j);
                    min = Math.min(min, need + findMinStep(newBoard, hand));
                    // backtrack
                    hand.put(board.charAt(i), hand.get(board.charAt(i)) + need);
                }
            }
            i = j;
        }
        return  min;
    }

    private static String remove(String board) {
        for (int i = 0, j = 0; j < board.length(); j++) {
            if (board.charAt(j) == board.charAt(i)) {
                continue;
            }
            if (j - i >= 3) {
                return remove(board.substring(0, i) + board.substring(j));
            }
            i = j;
        }
        return board;
    }
}
