package leetcode;

/**
 * https://leetcode.com/problems/solve-the-equation/
 */
public class Problem640 {
    public String solveEquation(String equation) {
        String[] e = equation.split("=");
        String lhs = e[0];
        VarConst lhsvc = parse(lhs);
        String rhs = e[1];
        VarConst rhsvc = parse(rhs);
        int variable = lhsvc.variable - rhsvc.variable;
        int constant = rhsvc.constant - lhsvc.constant;
        if (variable == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (variable == 0 && constant != 0) {
            return "No solution";
        }
        return "x=" + (constant / variable);
    }

    private static VarConst parse(String eq) {
        VarConst varConst = new VarConst();
        int prev = 0;
        int curr = 0;
        for (; curr < eq.length(); curr++) {
            if (curr != 0 && (eq.charAt(curr) == '+' || eq.charAt(curr) == '-')) {
                String sub = eq.substring(prev, curr);
                update(varConst, sub);
                prev = curr;
            }
        }
        String sub = eq.substring(prev, curr);
        update(varConst, sub);
        return varConst;
    }

    private static void update(VarConst varConst, String sub) {
        if (sub.contains("x")) {
            sub = sub.replaceAll("x", "");
            if (sub.isEmpty() || sub.equals("+")) {
                varConst.variable += 1;
            } else if (sub.equals("-")) {
                varConst.variable += -1;
            } else {
                varConst.variable += Integer.parseInt(sub);
            }
        } else {
            varConst.constant += Integer.parseInt(sub);
        }
    }

    private static class VarConst {
        private int variable;
        private int constant;
    }
}
