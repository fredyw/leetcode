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
                if (s[i] == 'R' && s[i + 1] == 'X') {
                    swap(s, i, i + 1);
                } else if (e[i] == 'L') {
                    int j = i;
                    while (j < s.length && s[j] == 'X') {
                        j++;
                    }
                    if (s[j] != 'L') {
                        return false;
                    }
                    swap(s, i, j);
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
//        System.out.println(prob.canTransform("RL", "LR")); // false
//        System.out.println(prob.canTransform("XXXXXLXXXX", "LXXXXXXXXX")); // true
//        System.out.println(prob.canTransform("RXXXXL", "RLXXXX")); // true
//        System.out.println(prob.canTransform("RXXXXL", "RLXXXX")); // true
//        System.out.println(prob.canTransform("RXXXXL", "XXXXRL")); // true
//        System.out.println(prob.canTransform("XLXRRXXRXX", "LXXXXXXRRR")); // true
        System.out.println(prob.canTransform("XLXRRXXRXXXL", "LXXXXXXRRRLX")); // true
//        System.out.println(prob.canTransform("XLXXXXLXLX", "LLLXXXXXXX")); // true
    }
}
