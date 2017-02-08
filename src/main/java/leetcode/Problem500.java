package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/keyboard-row/
 */
public class Problem500 {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        update(map, "qwertyuiop", 1);
        update(map, "asdfghjkl", 2);
        update(map, "zxcvbnm", 3);
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int row = 0;
            boolean valid = true;
            for (int j = 0; j < word.length(); j++) {
                if (j == 0) {
                    row = map.get(word.charAt(j));
                } else {
                    if (row != map.get(word.charAt(j))) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) {
                result.add(words[i]);
            }
        }
        return result.toArray(new String[0]);
    }

    private static void update(Map<Character, Integer> map, String str, int row) {
        for (char c : str.toCharArray()) {
            map.put(c, row);
        }
    }
}
