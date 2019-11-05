package leetcode;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
public class Problem1247 {
    public int minimumSwap(String s1, String s2) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1247 prob = new Problem1247();
        System.out.println(prob.minimumSwap("xx", "yy")); // 1
        System.out.println(prob.minimumSwap("xy", "yx")); // 2
        System.out.println(prob.minimumSwap("xx", "xy")); // -1
        System.out.println(prob.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx")); // 4
    }
}
