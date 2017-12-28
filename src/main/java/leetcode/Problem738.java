package leetcode;

/**
 * https://leetcode.com/problems/monotone-increasing-digits/
 */
public class Problem738 {
    public int monotoneIncreasingDigits(int N) {
        String str = Integer.toString(N);
        StringBuilder sb = new StringBuilder();
        boolean nine = false;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (nine) {
                sb.append('9');
                continue;
            }
            if (i + 1 < str.length()) {
                if (str.charAt(i) < str.charAt(i + 1)) {
                    for (int j = 0; j < count; j++) {
                        sb.append(str.charAt(i));
                    }
                    sb.append(str.charAt(i));
                    count = 0;
                } else if (str.charAt(i) > str.charAt(i + 1)) {
                    if (str.charAt(i) - 1 != '0') {
                        sb.append((char) (str.charAt(i) - 1));
                    }
                    for (int j = 0; j < count; j++) {
                        sb.append('9');
                    }
                    nine = true;
                    count = 0;
                } else {
                    count++;
                }
            }
        }
        if (!nine) {
            for (int j = 0; j < count; j++) {
                sb.append(str.charAt(str.length() - 1));
            }
            sb.append(str.charAt(str.length() - 1));
        }
        return Integer.parseInt(sb.toString());
    }
}
