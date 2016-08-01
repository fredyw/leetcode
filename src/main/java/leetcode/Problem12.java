package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/integer-to-roman/
 */
public class Problem12 {
    public String intToRoman(int num) {
        Map<Integer, String> map = buildRomanNumerals();
        Set<Integer> keys = new TreeSet<>(map.keySet());
        int n = 0;
        int tmp = num;
        while (tmp != 0) {
            tmp /= 10;
            n++;
        }
        Stack<Integer> numbers = new Stack<>();
        tmp = num;
        int b = 0;
        for (int i = 1; i <= n; i++) {
            int a = tmp % (int) (Math.pow(10, i));
            numbers.push(a - b);
            b = a;
        }
        StringBuilder roman = new StringBuilder();
        while (!numbers.isEmpty()) {
            int number = numbers.pop();
            if (map.containsKey(number)) {
                roman.append(map.get(number));
            } else {
                if (number == 0) {
                    continue;
                }
                Roman r = find(number, map, keys);
                int y = number / r.integer;
                for (int i = 0; i < y; i++) {
                    roman.append(r.roman);
                }
                int x = number % r.integer;
                while (x != 0) {
                    r = find(x, map, keys);
                    y = x / r.integer;
                    for (int i = 0; i < y; i++) {
                        roman.append(r.roman);
                    }
                    x = x % r.integer;

                }
            }
        }
        return roman.toString();
    }

    private static class Roman {
        private Integer integer;
        private String roman;

        public Roman(Integer integer, String roman) {
            this.integer = integer;
            this.roman = roman;
        }
    }

    private Roman find(int number, Map<Integer, String> map, Set<Integer> keys) {
        Integer integer = null;
        String roman = null;
        for (int key : keys) {
            if (number < key) {
                break;
            }
            integer = key;
            roman = map.get(key);
        }
        return new Roman(integer, roman);
    }

    private Map<Integer, String> buildRomanNumerals() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        return map;
    }
}
