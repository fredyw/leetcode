package leetcode;

/**
 * https://leetcode.com/problems/solve-the-equation/
 */
public class Problem640 {
    public String solveEquation(String equation) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem640 prob = new Problem640();
        System.out.println(prob.solveEquation("x+5-3+x=6+x-2")); // x=2
        System.out.println(prob.solveEquation("x=x")); // Infinite solutions
        System.out.println(prob.solveEquation("2x=x")); // x=0
        System.out.println(prob.solveEquation("2x+3x-6x=x+2")); // x=-1
        System.out.println(prob.solveEquation("x=x+2")); // No solution
    }
}
