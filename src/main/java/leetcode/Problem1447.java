package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/simplified-fractions/
 */
public class Problem1447 {
    public List<String> simplifiedFractions(int n) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1447 prob = new Problem1447();
        System.out.println(prob.simplifiedFractions(2)); // ["1/2"]
        System.out.println(prob.simplifiedFractions(3)); // ["1/2","1/3","2/3"]
        System.out.println(prob.simplifiedFractions(4)); // ["1/2","1/3","1/4","2/3","3/4"]
        System.out.println(prob.simplifiedFractions(1)); // []
    }
}
