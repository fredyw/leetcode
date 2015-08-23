package leetcode;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 */
public class Problem233 {
    public int countDigitOne(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
        }
        return result;
    }
    
    public static void main(String[] args) {
        Problem233 prob = new Problem233();
        System.out.println(prob.countDigitOne(13));
        System.out.println(prob.countDigitOne(824883294));
    }
}
