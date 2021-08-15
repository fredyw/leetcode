package leetcode;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 */
public class Problem1963 {
    public int minSwaps(String s) {
        char[] chars = s.toCharArray();
        int[] openIndexes = new int[s.length() / 2];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
           if (s.charAt(i) == '[') {
               openIndexes[j++] = i;
           }
        }
        int answer = 0;
        int numOpen = 0;
        int openIndex = openIndexes.length - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                numOpen++;
            } else {
                if (numOpen - 1 < 0) {
                    char tmp = chars[i];
                    chars[i] = chars[openIndexes[openIndex]];
                    chars[openIndexes[openIndex]] = tmp;
                    openIndex--;
                    numOpen++;
                    answer++;
                } else {
                    numOpen--;
                }
            }
        }
        return answer;
    }
}
