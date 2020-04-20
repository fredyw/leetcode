package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/reformat-the-string/
 */
public class Problem1417 {
    public String reformat(String s) {
        List<Character> chars = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numbers.add(c);
            } else {
                chars.add(c);
            }
        }
        if (Math.abs(chars.size() - numbers.size()) > 1) {
            return "";
        }
        String answer = "";
        boolean isNumber = chars.size() <= numbers.size();
        int i = 0;
        int j = 0;
        while (i < chars.size() && j < numbers.size()) {
            answer += isNumber ? numbers.get(i++) : chars.get(j++);
            isNumber = !isNumber;
        }
        if (isNumber) {
            answer += i < numbers.size() ? numbers.get(i) : "";
            answer += j < chars.size() ? chars.get(j) : "";
        } else {
            answer += j < chars.size() ? chars.get(j) : "";
            answer += i < numbers.size() ? numbers.get(i) : "";
        }
        return answer;
    }
}
