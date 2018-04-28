package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/ambiguous-coordinates/
 */
public class Problem816 {
    public List<String> ambiguousCoordinates(String S) {
        List<String> result = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; i++) {
            String first = S.substring(1, i);
            String second = S.substring(i, S.length() - 1);
            List<String> firstNumbers = makeNumbers(first);
            List<String> secondNumbers = makeNumbers(second);
            if (!firstNumbers.isEmpty() && !secondNumbers.isEmpty()) {
                for (String fn : firstNumbers) {
                    for (String sn : secondNumbers) {
                        result.add("(" + fn + ", " + sn + ")");
                    }
                }
            }
        }
        return result;
    }

    private static boolean isFirstValid(String s) {
        if (s.length() == 1) {
            return true;
        }
        return s.charAt(0) != '0';
    }

    private static boolean isSecondValid(String s) {
        return s.charAt(s.length() - 1) != '0';
    }

    private static List<String> makeNumbers(String s) {
        List<String> result = new ArrayList<>();
        if (isFirstValid(s)) {
            result.add(s);
        }
        for (int i = 1; i < s.length(); i++) {
            String first = s.substring(0, i);
            String second = s.substring(i);
            if (isFirstValid(first) && isSecondValid(second)) {
                result.add(first + "." + second);
            }
        }
        return result;
    }
}
