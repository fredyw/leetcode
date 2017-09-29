package leetcode;

/**
 * https://leetcode.com/problems/valid-parenthesis-string/
 */
public class Problem678 {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }

    private static boolean check(String s, int idx, int opening) {
        if (opening < 0) {
            return false;
        }
        if (s.length() == idx) {
            if (opening == 0) {
                return true;
            }
            return false;
        }
        if (s.charAt(idx) == '(') {
            return check(s, idx + 1, opening + 1);
        } else if (s.charAt(idx) == ')') {
            return check(s, idx + 1, opening - 1);
        } else {
            boolean a = check(s, idx + 1, opening + 1); // (
            boolean b = check(s, idx + 1, opening); // )
            boolean c = check(s, idx + 1, opening - 1); // empty
            return a || b || c;
        }
    }

    public static void main(String[] args) {
        Problem678 prob = new Problem678();
        System.out.println(prob.checkValidString("()")); // true
        System.out.println(prob.checkValidString("(*)")); // true
        System.out.println(prob.checkValidString("(*))")); // true
        System.out.println(prob.checkValidString(")(")); // false
        System.out.println(prob.checkValidString("()()")); // true
        System.out.println(prob.checkValidString("(**())")); // true
    }
}
