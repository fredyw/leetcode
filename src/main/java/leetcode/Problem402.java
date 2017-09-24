package leetcode;

/**
 * https://leetcode.com/problems/remove-k-digits/
 */
public class Problem402 {
    public String removeKdigits(String num, int k) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem402 prob = new Problem402();
        System.out.println(prob.removeKdigits("1432219", 3)); // 1432219
        System.out.println(prob.removeKdigits("10200", 1)); // 200
        System.out.println(prob.removeKdigits("10", 2)); // 0
        System.out.println(prob.removeKdigits("1234", 2)); // 12
        System.out.println(prob.removeKdigits("4321", 2)); // 21
        System.out.println(prob.removeKdigits("31299", 2)); // 129
    }
}
