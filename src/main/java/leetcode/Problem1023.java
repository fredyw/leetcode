package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/camelcase-matching/
 */
public class Problem1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> answer = new ArrayList<>();
        for (String query : queries) {
            int i = 0;
            int j = 0;
            boolean found = true;
            while (i < pattern.length() && j < query.length()) {
                if (Character.isLowerCase(pattern.charAt(i))) {
                    while (j < query.length() && pattern.charAt(i) != query.charAt(j)) {
                        j++;
                    }
                } else { // Character.isUpperCase(pattern.charAt(i))
                    while (j < query.length() && Character.isLowerCase(query.charAt(j))) {
                        j++;
                    }
                }
                if (j >= query.length() || pattern.charAt(i) != query.charAt(j)) {
                    found = false;
                    break;
                }
                i++;
                j++;
            }
            while (j < query.length()) {
                if (Character.isUpperCase(query.charAt(j))) {
                    found = false;
                    break;
                }
                j++;
            }
            answer.add(i < pattern.length() ? false : found);
        }
        return answer;
    }
}
