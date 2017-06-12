package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<Character>> numbers = new HashMap<>();
        numbers.put(2, Arrays.asList('a', 'b', 'c'));
        numbers.put(3, Arrays.asList('d', 'e', 'f'));
        numbers.put(4, Arrays.asList('g', 'h', 'i'));
        numbers.put(5, Arrays.asList('j', 'k', 'l'));
        numbers.put(6, Arrays.asList('m', 'n', 'o'));
        numbers.put(7, Arrays.asList('p', 'q', 'r', 's'));
        numbers.put(8, Arrays.asList('t', 'u', 'v'));
        numbers.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        letterCombinations(digits, numbers, 0, "", result);

        return result;
    }

    private void letterCombinations(String digits,
                                    Map<Integer, List<Character>> numbers, int n, String accu,
                                    List<String> result) {
        if (n == digits.length()) {
            result.add(accu);
            return;
        }
        int digit = Integer.parseInt(Character.toString(digits.charAt(n)));
        for (Character c : numbers.get(digit)) {
            letterCombinations(digits, numbers, n + 1, accu + c, result);
        }
    }
}
