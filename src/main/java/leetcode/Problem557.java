package leetcode;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class Problem557 {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                sb.append(reverse(split[i].toCharArray()));
            } else {
                sb.append(" " + reverse(split[i].toCharArray()));
            }
        }
        return sb.toString();
    }

    private static String reverse(char[] chars) {
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
