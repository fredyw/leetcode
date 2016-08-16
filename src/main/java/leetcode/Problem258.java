package leetcode;

/**
 * https://leetcode.com/problems/add-digits/
 */
public class Problem258 {
    public int addDigits(int num) {
        int n = num;
        String s = Integer.toString(n);
        while (s.length() != 1) {
            n = 0;
            for (char c : s.toCharArray()) {
                int i = Integer.parseInt(Character.toString(c));
                n += i;
            }
            s = Integer.toString(n);
        }
        return n;
    }
}
