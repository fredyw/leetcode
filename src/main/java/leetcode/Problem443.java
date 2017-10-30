package leetcode;

/**
 * https://leetcode.com/problems/string-compression/
 */
public class Problem443 {
    public int compress(char[] chars) {
        int j = 0;
        char ch = ' ';
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            if (i != 0) {
                if (chars[i] != ch) {
                    chars[j] = ch;
                    j++;
                    if (count > 1) {
                        char[] countArray = Integer.toString(count).toCharArray();
                        for (int k = 0; k < countArray.length; k++) {
                            chars[j++] = countArray[k];
                        }
                    }
                    count = 1;
                } else {
                    count++;
                }
            }
            ch = chars[i];
        }
        chars[j] = ch;
        j++;
        if (count > 1) {
            char[] countArray = Integer.toString(count).toCharArray();
            for (int k = 0; k < countArray.length; k++) {
                chars[j++] = countArray[k];
            }
        }
        return j;
    }
}
