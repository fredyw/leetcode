package leetcode;

/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 */
public class Problem1625 {
    public String findLexSmallestString(String s, int a, int b) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1625 prob = new Problem1625();
        System.out.println(prob.findLexSmallestString("5525", 9, 2)); // "2050"
        System.out.println(prob.findLexSmallestString("74", 5, 1)); // "24"
        System.out.println(prob.findLexSmallestString("0011", 4, 2)); // "0011"
        System.out.println(prob.findLexSmallestString("43987654", 7, 3)); // "00553311"
    }
}
