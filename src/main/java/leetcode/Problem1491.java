package leetcode;

/**
 * https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class Problem1491 {
    public double average(int[] salary) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1491 prob = new Problem1491();
        System.out.println(prob.average(new int[]{4000,3000,1000,2000})); // 2500.00000
        System.out.println(prob.average(new int[]{1000,2000,3000})); // 2000.00000
        System.out.println(prob.average(new int[]{6000,5000,4000,3000,2000,1000})); // 3500.00000
        System.out.println(prob.average(new int[]{8000,9000,2000,3000,6000,1000})); //  4750.00000
    }
}
