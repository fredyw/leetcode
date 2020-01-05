package leetcode;

/**
 * https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
 */
public class Problem5303 {
    public String freqAlphabets(String s) {
        String answer = "";
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                answer += toChar(Integer.parseInt(s.substring(i, i + 2)));
                i += 3;
            } else {
                answer += toChar(Integer.parseInt("" + s.charAt(i)));
                i++;
            }
        }
        return answer;
    }

    private static char toChar(int n) {
        return (char) (n + 'a' - 1);
    }
}
