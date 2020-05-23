package leetcode;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 */
public class Problem1432 {
    public int maxDiff(int num) {
        String s = Integer.toString(num);
        int i = 0;
        while (i < s.length() && s.charAt(i) == '9') {
            i++;
        }
        StringBuilder max = new StringBuilder();
        if (i == s.length()) {
            i = 0;
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                max.append("9");
            } else {
                max.append(s.charAt(j));
            }
        }
        StringBuilder min = new StringBuilder();
        i = 0;
        boolean zero = false;
        if (s.charAt(i) == '1') {
            while (i < s.length() && (s.charAt(i) == '0' || s.charAt(i) == '1')) {
                i++;
            }
            if (i == s.length()) {
                i = 0;
            } else {
                zero = true;
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j)) {
                min.append(zero ? "0" : "1");
            } else {
                min.append(s.charAt(j));
            }
        }
        return Integer.parseInt(max.toString()) - Integer.parseInt(min.toString());
    }
}
