package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 */
public class Problem1237 {
    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        int f(int x, int y);
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
    }
}
