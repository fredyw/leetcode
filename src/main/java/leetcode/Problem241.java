package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class Problem241 {
    public List<Integer> diffWaysToCompute(String input) {
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            List<Integer> list = new ArrayList<>();
            list.add(Integer.valueOf(input));
            return list;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-'
                || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, input.length()));
                for (int l : left) {
                    for (int r : right) {
                        if (input.charAt(i) == '+') {
                            result.add(l + r);
                        } else if (input.charAt(i) == '-') {
                            result.add(l - r);
                        } else if (input.charAt(i) == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        return result;
    }
}
