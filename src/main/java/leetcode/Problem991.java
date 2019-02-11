package leetcode;

/**
 * https://leetcode.com/problems/broken-calculator/
 */
public class Problem991 {
    public int brokenCalc(int X, int Y) {
        if (X == Y) {
            return 0;
        }
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        if (X < Y) {
            a = brokenCalc(X * 2, Y) + 1;
        }
        if (X > Y) {
            b = brokenCalc(X - 1, Y) + 1;
        }
        int min = Math.min(a, b);
        return min;
    }

    public static void main(String[] args) {
        Problem991 prob = new Problem991();
//        System.out.println(prob.brokenCalc(2, 3)); // 2
//        System.out.println(prob.brokenCalc(5, 8)); // 2
        System.out.println(prob.brokenCalc(3, 10)); // 3
//        System.out.println(prob.brokenCalc(1024, 1)); // 1023
    }
}
