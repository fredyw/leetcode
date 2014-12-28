package leetcode;

/**
 * https://oj.leetcode.com/problems/count-and-say/
 */
public class Problem38 {
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        for (int i = 1; i < n; i++) {
            str = countAndSay(str);
        }
        return str;
    }
    
    private String countAndSay(String str) {
        char c = str.charAt(0);
        StringBuilder newString = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                newString.append(count);
                newString.append(c);
                c = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        newString.append(count);
        newString.append(c);
        return newString.toString();
    }
}
