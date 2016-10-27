package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 */
public class Problem423 {
    public String originalDigits(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charCount.containsKey(c)) {
                charCount.put(c, 1);
            } else {
                charCount.put(c, charCount.get(c) + 1);
            }
        }
        List<Map<Character, Integer>> uniqueIdentifiers = uniqueIdentifiers();
        List<Integer> result = new ArrayList<>();
        for (Map<Character, Integer> map : uniqueIdentifiers) {
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Integer count = charCount.get(entry.getKey());
                if (count == null) {
                    continue;
                }
                int val = entry.getValue();
                if (val == 0) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'z');
                        removeChar(charCount, 'e');
                        removeChar(charCount, 'r');
                        removeChar(charCount, 'o');
                        result.add(0);
                    }
                } else if (val == 1) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'o');
                        removeChar(charCount, 'n');
                        removeChar(charCount, 'e');
                        result.add(1);
                    }
                } else if (val == 2) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 't');
                        removeChar(charCount, 'w');
                        removeChar(charCount, 'o');
                        result.add(2);
                    }
                } else if (val == 3) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 't');
                        removeChar(charCount, 'h');
                        removeChar(charCount, 'r');
                        removeChar(charCount, 'e');
                        removeChar(charCount, 'e');
                        result.add(3);
                    }
                } else if (val == 4) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'f');
                        removeChar(charCount, 'o');
                        removeChar(charCount, 'u');
                        removeChar(charCount, 'r');
                        result.add(4);
                    }
                } else if (val == 5) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'f');
                        removeChar(charCount, 'i');
                        removeChar(charCount, 'v');
                        removeChar(charCount, 'e');
                        result.add(5);
                    }
                } else if (val == 6) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 's');
                        removeChar(charCount, 'i');
                        removeChar(charCount, 'x');
                        result.add(6);
                    }
                } else if (val == 7) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 's');
                        removeChar(charCount, 'e');
                        removeChar(charCount, 'v');
                        removeChar(charCount, 'e');
                        removeChar(charCount, 'n');
                        result.add(7);
                    }
                } else if (val == 8) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'e');
                        removeChar(charCount, 'i');
                        removeChar(charCount, 'g');
                        removeChar(charCount, 'h');
                        removeChar(charCount, 't');
                        result.add(8);
                    }
                } else if (val == 9) {
                    for (int i = 0; i < count; i++) {
                        removeChar(charCount, 'n');
                        removeChar(charCount, 'i');
                        removeChar(charCount, 'n');
                        removeChar(charCount, 'e');
                        result.add(9);
                    }
                }
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
        }
        return sb.toString();
    }

    private static void removeChar(Map<Character, Integer> charCount, char c) {
        int count = charCount.get(c) - 1;
        if (count == 0) {
            charCount.remove(c);
        } else {
            charCount.put(c, count);
        }
    }

    private static List<Map<Character, Integer>> uniqueIdentifiers() {
        // one character that can uniquely identify the digit
        List<Map<Character, Integer>> identifiers = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        // first level
        map.put('z', 0);
        map.put('w', 2);
        map.put('u', 4);
        map.put('x', 6);
        map.put('g', 8);
        identifiers.add(map);
        // second level
        map = new HashMap<>();
        map.put('o', 1);
        map.put('h', 3);
        map.put('f', 5);
        map.put('s', 7);
        identifiers.add(map);
        // third level
        map = new HashMap<>();
        map.put('i', 9);
        identifiers.add(map);
        return identifiers;
    }
}
