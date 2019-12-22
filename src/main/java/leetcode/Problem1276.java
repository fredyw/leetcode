package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 */
public class Problem1276 {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1276 prob = new Problem1276();
        System.out.println(prob.numOfBurgers(16, 7)); // [1,6]
        System.out.println(prob.numOfBurgers(17, 4)); // []
        System.out.println(prob.numOfBurgers(4, 17)); // []
        System.out.println(prob.numOfBurgers(0, 0)); // [0,0]
        System.out.println(prob.numOfBurgers(2, 1)); // [0,1]
    }
}
