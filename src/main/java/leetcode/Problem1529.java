package leetcode;

/**
 * https://leetcode.com/problems/bulb-switcher-iv/
 */
public class Problem1529 {
    public int minFlips(String target) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1529 prob = new Problem1529();
        System.out.println(prob.minFlips("10111")); // 3
        System.out.println(prob.minFlips("101")); // 3
        System.out.println(prob.minFlips("00000")); // 0
        System.out.println(prob.minFlips("001011101")); // 5
        System.out.println(prob.minFlips("100100")); // 4
        System.out.println(prob.minFlips("100100")); // 4
        System.out.println(prob.minFlips("100111")); // 3
    }
}
