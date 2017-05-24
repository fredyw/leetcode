package leetcode;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/
 */
public class Problem592 {
    public String fractionAddition(String expression) {
        // TODO
        return "";
    }

    public static void main(String[] args) {
        Problem592 prob = new Problem592();
        System.out.println(prob.fractionAddition("-1/2+1/2")); // 0/1
        System.out.println(prob.fractionAddition("-1/2+1/2+1/3")); // 1/3
        System.out.println(prob.fractionAddition("1/3-1/2")); // -1/6
        System.out.println(prob.fractionAddition("5/3+1/3")); // 2/1
    }
}
