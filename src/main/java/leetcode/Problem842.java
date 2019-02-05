package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class Problem842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> answer = new ArrayList<>();
        if (S.length() < 3) {
            return answer;
        }
        int maxLength = Integer.toString(Integer.MAX_VALUE).length();
        for (int i = 1; i <= S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                String sub = S.substring(0, i);
                if (sub.length() > maxLength) {
                    continue;
                }
                long val = Long.parseLong(sub);
                if (val > Integer.MAX_VALUE) {
                    continue;
                }
                answer.add((int) val);
                if (splitIntoFibonacci(S, 0, i, i, j, answer) && answer.size() >= 3) {
                    return answer;
                } else {
                    answer.clear();
                }
            }
        }
        return answer;
    }

    private static boolean splitIntoFibonacci(String s, int i, int j, int k, int l, List<Integer> answer) {
        int maxLength = Integer.toString(Integer.MAX_VALUE).length();
        if (l == s.length()) {
            String sub = s.substring(k, l);
            if (sub.length() > maxLength || (sub.length() > 1 && sub.startsWith("0"))) {
                return false;
            }
            long val = Long.parseLong(sub);
            if (val > Integer.MAX_VALUE) {
                return false;
            }
            answer.add((int) val);
            return true;
        }
        String sub1 = s.substring(i, j);
        if (sub1.length() > maxLength || (sub1.length() > 1 && sub1.startsWith("0"))) {
            return false;
        }
        long num1 = Long.parseLong(sub1);
        if (num1 > Integer.MAX_VALUE) {
            return false;
        }
        String sub2 = s.substring(k, l);
        if (sub2.length() > maxLength || (sub2.length() > 1 && sub2.startsWith("0"))) {
            return false;
        }
        long num2 = Long.parseLong(sub2);
        if (num2 > Integer.MAX_VALUE) {
            return false;
        }
        long sum = num1 + num2;
        if (sum > Integer.MAX_VALUE) {
            return false;
        }
        String sumStr = Long.toString(sum);
        boolean found = false;
        if (l + sumStr.length() <= s.length() && sumStr.equals(s.substring(l, l + sumStr.length()))) {
            answer.add((int) num2);
            found = splitIntoFibonacci(s, k, l, l, l + sumStr.length(), answer);
            if (!found) {
                answer.remove(answer.size() - 1);
            }
        }
        return found;
    }
}
