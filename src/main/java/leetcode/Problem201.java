package leetcode;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 */
public class Problem201 {
    public int rangeBitwiseAnd(int m, int n) {
        int result = m;
        for (int i = m+1; i <= n; i++) {
            result &= i;
        }
        return result;
    }
    
    public static void main(String[] args) {
        Problem201 prob = new Problem201();
        System.out.println(prob.rangeBitwiseAnd(5, 7)); // 4
    }
}
