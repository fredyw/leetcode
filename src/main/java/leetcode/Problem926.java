package leetcode;

/**
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */
public class Problem926 {
    public int minFlipsMonoIncr(String S) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem926 prob = new Problem926();
        System.out.println(prob.minFlipsMonoIncr("00110")); // 1
        System.out.println(prob.minFlipsMonoIncr("010110")); // 2
        System.out.println(prob.minFlipsMonoIncr("00011000")); // 2
        System.out.println(prob.minFlipsMonoIncr("0100111")); // 1
        System.out.println(prob.minFlipsMonoIncr("100100111")); // 2
        System.out.println(prob.minFlipsMonoIncr("00001")); // 0
        System.out.println(prob.minFlipsMonoIncr("11110")); // 1
        System.out.println(prob.minFlipsMonoIncr("11100")); // 2
    }
}
