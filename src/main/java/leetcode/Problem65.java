package leetcode;

/**
 * https://leetcode.com/problems/valid-number/
 */
public class Problem65 {
    public boolean isNumber(String s) {
        return s.matches("\\s*(?:-|\\+)?(\\d+|(?:\\d+\\.\\d*)|(?:\\d*\\.\\d+))(e(?:-|\\+)?\\d+)?\\s*");
    }

    private static void test(boolean actual, boolean expected) {
        if (actual != expected) {
            throw new RuntimeException("Wrong!");
        }
    }

    public static void main(String[] args) {
        Problem65 prob = new Problem65();
        test(prob.isNumber("0"), true); // true
        test(prob.isNumber("123.45"), true); // true
        test(prob.isNumber(" 0.1"), true); // true
        test(prob.isNumber("abc"), false); // false
        test(prob.isNumber("1 a"), false); // false
        test(prob.isNumber("2e10"), true); // true
        test(prob.isNumber("1.2e10"), true); // true
        test(prob.isNumber("1.2e-10"), true); // true
        test(prob.isNumber(".1"), true); // true
        test(prob.isNumber(""), false); // false
        test(prob.isNumber("e9"), false); // false
        test(prob.isNumber("1.21.2"), false); // false
        test(prob.isNumber("1.2e1.2"), false); // false
        test(prob.isNumber("3."), true); // true
        test(prob.isNumber("."), false); // false
        test(prob.isNumber("-12."), true); // true
        test(prob.isNumber("-.234"), true); // true
        test(prob.isNumber("-2.2e3.4"), false); // false
        test(prob.isNumber("-2.2e-3.4"), false); // false
        test(prob.isNumber("+.8"), true); // true
        test(prob.isNumber(" 005047e+6"), true); // true
    }
}
