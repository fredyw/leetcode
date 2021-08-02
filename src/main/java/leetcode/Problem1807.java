package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class Problem1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> keyValue : knowledge) {
            map.put(keyValue.get(0), keyValue.get(1));
        }
        StringBuilder answer = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                i++;
                StringBuilder sb = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ')') {
                    sb.append(s.charAt(i));
                    i++;
                }
                String str = sb.toString();
                answer.append(map.getOrDefault(str, "?"));
            } else {
                answer.append(s.charAt(i));
            }
            i++;
        }
        return answer.toString();
    }
}
