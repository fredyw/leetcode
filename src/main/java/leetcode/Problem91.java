package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/decode-ways/
 */
public class Problem91 {
    public int numDecodings(String s) {
        Map<String, Character> charMap = getCharMap();
        return numDecodings(s, charMap, s.length()) + 1;
    }

    private int numDecodings(String s, Map<String, Character> map, int limit) {
        if (limit <= 2) {
            if (map.containsKey(s)) {
                return 1;
            }
            return 0;
        }
        int n = 0;
        for (int i = 0; i < s.length()-1; i++) {
            String s1 = s.substring(0, i+1);
            String s2 = s.substring(i+1);
            if (map.containsKey(s1)) {
                n++;
            }
            if (map.containsKey(s2)) {
                n++;
            }
            System.out.println(s1 + " " + s2);
            int n1 = numDecodings(s1, map, limit-1);
            int n2 = numDecodings(s2, map, limit-1);
            n += n1 + n2;
        }
        return n;
    }

    private Map<String, Character> getCharMap() {
        Map<String, Character> map = new HashMap<>();
        int c = (int) 'a';
        for (int i = 1; i <= 26; i++) {
            map.put(Integer.toString(i), (char) c);
            c++;
        }
        return map;
    }

    public static void main(String[] args) {
        Problem91 prob = new Problem91();
//        System.out.println(prob.numDecodings("12"));
//        System.out.println(prob.numDecodings("215"));
        System.out.println(prob.numDecodings("1215"));
    }
}
