package leetcode;

/**
 * https://leetcode.com/problems/to-lower-case/
 */
public class Problem709 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        int diff = 'a' - 'A';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char) (str.charAt(i) + diff));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
