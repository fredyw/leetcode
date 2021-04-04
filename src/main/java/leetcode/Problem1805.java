package leetcode;

/**
 * https://leetcode.com/problems/number-of-different-integers-in-a-string/
 */
public class Problem1805 {
    public int numDifferentIntegers(String word) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1805 prob = new Problem1805();
        System.out.println(prob.numDifferentIntegers("a123bc34d8ef34")); // 3
        System.out.println(prob.numDifferentIntegers("leet1234code234")); // 2
        System.out.println(prob.numDifferentIntegers("a1b01c001")); // 1
    }
}
