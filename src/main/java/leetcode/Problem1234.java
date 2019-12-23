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
        for (char c: arr) {
            count.put(c, count.get(c) + 1);
        }
        int need = arr.length / 4;
        int left = 0;
        int right = 0;
        int min = arr.length;
        while (right <= arr.length) {
            if (count.get('Q') > need || count.get('W') > need ||
                count.get('E') > need || count.get('R') > need) {
                if (right >= arr.length) {
                    break;
                }
                count.put(arr[right], count.get(arr[right]) - 1);
                right++;
                continue;
            }
            min = Math.min(min, right-left);
            if (min == 0) {
                break;
            }
            count.put(arr[left], count.get(arr[left]) + 1);
            left++;
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        Problem1234 prob = new Problem1234();
//        System.out.println(prob.balancedString("QWER")); // 0
//        System.out.println(prob.balancedString("QQWE")); // 1
//        System.out.println(prob.balancedString("QQQW")); // 2
//        System.out.println(prob.balancedString("QQQQ")); // 3
//        System.out.println(prob.balancedString("WQWRQQQW")); // 3
        System.out.println(prob.balancedString("WWEQERQWQWWRWWERQWEQ")); // 4
//        System.out.println(prob.balancedString("QQQWEEER")); // 3
    }
}
