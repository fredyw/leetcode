package leetcode;

/**
 * https://leetcode.com/problems/shifting-letters/
 */
public class Problem848 {
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        for (int i = 0; i < shifts.length; i++) {
            for (int j = 0; j <= i; j++) {
                int val = (chars[j] - 'a' + shifts[i]) % 26;
                chars[j] = (char) ('a' + val);
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Problem848 prob = new Problem848();
        System.out.println(prob.shiftingLetters("abc", new int[]{3, 5, 9})); // rpl
        System.out.println(prob.shiftingLetters("bad", new int[]{10, 20, 30})); // jyh
    }
}
