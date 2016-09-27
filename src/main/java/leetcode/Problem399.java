package leetcode;

/**
 * https://leetcode.com/problems/evaluate-division/
 */
public class Problem399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem399 prob = new Problem399();
        System.out.println(prob.calcEquation(
            new String[][]{{"a", "b"}, {"b", "c"}},
            new double[]{2.0, 3.0},
            new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}})); // [6.0, 0.5, -1.0, 1.0, -1.0 ]
    }
}
