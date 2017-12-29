package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/shortest-completing-word/
 */
public class Problem749 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String plate = licensePlate.toLowerCase();
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < plate.length(); i++) {
            if (plate.charAt(i) >= 'a' && plate.charAt(i) <= 'z') {
                if (!charCounts.containsKey(plate.charAt(i))) {
                    charCounts.put(plate.charAt(i), 1);
                } else {
                    charCounts.put(plate.charAt(i), charCounts.get(plate.charAt(i)) + 1);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        String result = "";
        for (String word : words) {
            Map<Character, Integer> copyCharCounts = new HashMap<>(charCounts);
            for (char c : word.toCharArray()) {
                if (copyCharCounts.containsKey(c)) {
                    Integer newCount = copyCharCounts.get(c) - 1;
                    if (newCount == 0) {
                        copyCharCounts.remove(c);
                    } else {
                        copyCharCounts.put(c, newCount);
                    }
                }
            }
            if (copyCharCounts.isEmpty()) {
                if (word.length() < min) {
                    min = word.length();
                    result = word;
                }
            }
        }
        return result;
    }
}
