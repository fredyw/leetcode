package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/
 */
public class Problem394 {
    public String decodeString(String s) {
        Stack<String> strings = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        StringBuilder string = new StringBuilder();
        StringBuilder integer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                if (integer.length() > 0) {
                    counts.add(Integer.valueOf(integer.toString()));
                }
                if (string.length() > 0) {
                    strings.add(string.toString());
                }
                string = new StringBuilder();
                integer = new StringBuilder();
            } else if (c == ']') {
                if (integer.length() > 0) {
                    counts.add(Integer.valueOf(integer.toString()));
                }
                if (string.length() > 0) {
                    strings.add(string.toString());
                }
                int count = counts.pop();
                String str = strings.pop();
                StringBuilder newStr = new StringBuilder();
                for (int cnt = 0; cnt < count; cnt++) {
                    newStr.append(str);
                }
                if (!strings.isEmpty()) {
                    String pop = strings.pop();
                    pop += newStr;
                    strings.add(pop);
                } else {
                    strings.add(newStr.toString());
                }
                string = new StringBuilder();
                integer = new StringBuilder();
            } else if (c >= '0' && c <= '9') {
                if (string.length() > 0) {
                    strings.add(string.toString());
                }
                string = new StringBuilder();
                integer.append(c);
            } else {
                if (integer.length() > 0) {
                    counts.add(Integer.valueOf(integer.toString()));
                }
                integer = new StringBuilder();
                if (strings.size() > counts.size()) {
                    String pop = "";
                    if (!strings.isEmpty()) {
                        pop = strings.pop();
                    }
                    strings.add(pop + c);
                } else {
                    string.append(c);
                }
            }
        }
        if (string.length() > 0) {
            strings.add(string.toString());
        }
        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str);
        }
        return result.toString();
    }
}
