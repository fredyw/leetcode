package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 */
public class Problem13 {
    public int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        String upperCaseStr = s.toUpperCase();
        char[] chars = upperCaseStr.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i + 1 == chars.length) {
                result += romans.get(chars[i]);
                break;
            }
            if (romans.get(chars[i]) >= romans.get(chars[i + 1])) {
                result += romans.get(chars[i]);
            } else {
                result -= romans.get(chars[i]);
            }
        }
        return result;
    }
}
