package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/expression-add-operators/
 */
public class Problem282 {
    public List<String> addOperators(String num, int target) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem282 prob = new Problem282();
        System.out.println(prob.addOperators("123", 6)); // ["1+2+3", "1*2*3"]
        System.out.println(prob.addOperators("232", 8)); // ["2*3+2", "2+3*2"]
        System.out.println(prob.addOperators("105", 5)); // ["1*0+5","10-5"]
        System.out.println(prob.addOperators("00", 0)); // ["0+0", "0-0", "0*0"]
        System.out.println(prob.addOperators("3456237490", 9191)); // []
    }
}
