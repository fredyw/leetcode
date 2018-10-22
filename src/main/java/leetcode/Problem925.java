package leetcode;

/**
 * https://leetcode.com/problems/long-pressed-name/
 */
public class Problem925 {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length() < name.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) != typed.charAt(j)) {
                return false;
            }
            char c = name.charAt(i);
            int count1 = 1;
            while (i + 1 < name.length() && c == name.charAt(i + 1)) {
                i++;
                count1++;
            }
            int count2 = 0;
            while (j < typed.length() && c == typed.charAt(j)) {
                j++;
                count2++;
            }
            if (count1 > count2) {
                return false;
            }
            i++;
        }
        return i == name.length();
    }
}
