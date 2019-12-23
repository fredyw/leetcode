package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class Problem1234 {
    public int balancedString(String s) {
        Map<Character, Integer> count = new HashMap<>();
        count.put('Q', 0);
        count.put('W', 0);
        count.put('E', 0);
        count.put('R', 0);
        char[] arr = s.toCharArray();
        for (char c : arr) {
            count.put(c, count.get(c) + 1);
        }
        int need = arr.length / 4;
        int left = 0;
        int right = 0;
        int min = arr.length;
        out:
        while (right <= arr.length) {
            while (count.get('Q') > need || count.get('W') > need ||
                count.get('E') > need || count.get('R') > need) {
                if (right >= arr.length) {
                    break out;
                }
                count.put(arr[right], count.get(arr[right]) - 1);
                right++;
            }
            min = Math.min(min, right - left);
            if (min == 0) {
                break;
            }
            count.put(arr[left], count.get(arr[left]) + 1);
            left++;
        }
        return min;
    }
}
