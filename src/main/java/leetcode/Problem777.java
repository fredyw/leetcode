package leetcode;

/**
 * https://leetcode.com/problems/swap-adjacent-in-lr-string/
 */
public class Problem777 {
    public boolean canTransform(String start, String end) {
        char[] s = start.toCharArray();
        char[] e = end.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] != e[i]) {
                if (i + 1 == s.length) {
                    return false;
                }
                if ((s[i] == 'X' && s[i + 1] == 'L') ||
                    (s[i] == 'R' && s[i + 1] == 'X')) {
                    swap(e, i, i + 1);
                    if (s[i] != e[i]) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        Problem777 prob = new Problem777();
//        System.out.println(prob.canTransform("RXXLRXRXL", "XRLXXRRLX")); // true
//        System.out.println(prob.canTransform("RXXLRXRXL", "XRLXXRRLL")); // false
//        System.out.println(prob.canTransform("LR", "RL")); // false
        System.out.println(prob.canTransform("XXXXXLXXXX", "LXXXXXXXXX")); // true
    }
}
