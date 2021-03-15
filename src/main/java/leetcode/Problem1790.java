package leetcode;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class Problem1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (index1 == -1) {
                    index1 = i;
                } else if (index2 == -1) {
                    index2 = i;
                }
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        if (count == 0) {
            return true;
        }
        if (count != 2) {
            return false;
        }
        char[] chars = s2.toCharArray();
        chars[index1] = s2.charAt(index2);
        chars[index2] = s2.charAt(index1);
        return s1.equals(new String(chars));
    }
}
