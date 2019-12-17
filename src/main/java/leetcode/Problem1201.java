package leetcode;

/**
 * https://leetcode.com/problems/ugly-number-iii/
 */
public class Problem1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1201 prob = new Problem1201();
        System.out.println(prob.nthUglyNumber(3, 2, 3, 5)); // 4
        System.out.println(prob.nthUglyNumber(4, 2, 3, 4)); // 6
        System.out.println(prob.nthUglyNumber(5, 2, 11, 13)); // 10
        System.out.println(prob.nthUglyNumber(1000000000, 2, 217983653, 336916467)); // 1999999984
    }
}
