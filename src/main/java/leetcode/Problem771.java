package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/jewels-and-stones/
 */
public class Problem771 {
    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) {
                map.put(S.charAt(i), 1);
            } else {
                map.put(S.charAt(i), map.get(S.charAt(i)) + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < J.length(); i++) {
            if (map.containsKey(J.charAt(i))) {
                 result += map.get(J.charAt(i));
            }
        }
        return result;
    }
}
