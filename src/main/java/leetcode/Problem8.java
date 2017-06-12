package leetcode;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Problem8 {
    public int atoi(String str) {
        long result = 0;
        String trimmedStr = str.trim();
        if (trimmedStr.isEmpty()) {
            return (int) result;
        }
        boolean negative = false;
        int start = 0;
        if (trimmedStr.charAt(0) == '-') {
            negative = true;
            start = 1;
        } else if (trimmedStr.charAt(0) == '+') {
            start = 1;
        }
        int end = start;
        for (; end < trimmedStr.length(); end++) {
            char c = trimmedStr.charAt(end);
            if (c < 48 || c > 57) { // 0 - 9
                break;
            }
        }
        int j = 0;
        // from the start to the end, there should only be numbers
        for (int i = end - 1; i >= start; i--) {
            result += getNum(trimmedStr.charAt(i)) * Math.pow(10, j);
            j++;
        }
        if (negative) {
            result *= -1;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }

    private int getNum(char c) {
        return c - 48;
    }
}
