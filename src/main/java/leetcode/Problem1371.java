package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class Problem1371 {
    public int findTheLongestSubstring(String s) {
        int answer = 0;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int[] pow = {1, 2, 4, 8, 16};
        boolean[] odd = new boolean[5];
        int code = 0;
        Map<Integer, Integer> encoded = new HashMap<>();
        encoded.put(code, -1);
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < vowels.length; ++j) {
                if (s.charAt(i) == vowels[j]) {
                    code += (odd[j] ? -1 : 1) * pow[j];
                    odd[j] = !odd[j];
                    break;
                }
            }
            if (encoded.containsKey(code)) {
                answer = Math.max(answer, i - encoded.get(code));
            } else {
                encoded.put(code, i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1371 prob = new Problem1371();
//        System.out.println(prob.findTheLongestSubstring("eleetminicoworoep")); // 13
//        System.out.println(prob.findTheLongestSubstring("xxx")); // 0
//        System.out.println(prob.findTheLongestSubstring("aabbbbee")); // 8
        System.out.println(prob.findTheLongestSubstring("aaabbbbee")); // 8
//        System.out.println(prob.findTheLongestSubstring("aaaa")); // 4
//        System.out.println(prob.findTheLongestSubstring("leetcodeisgreat")); // 5
//        System.out.println(prob.findTheLongestSubstring("bcbcbc")); // 6
//        System.out.println(prob.findTheLongestSubstring("eleetminicoworoepo")); // 18
    }
}
