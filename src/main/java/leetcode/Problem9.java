package leetcode;

/**
 * https://oj.leetcode.com/problems/palindrome-number/
 */
public class Problem9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int n = 0;
        int tmp = x;
        while (tmp != 0) {
            n++;
            tmp /= 10;
        }
        while (n > 1) {
            int a = 0;
            int b = 0;
            int y = x;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    a = y % 10; 
                } else if (i == n-1) {
                    b = y % 10;
                }
                y /= 10;
            }
            x /= 10;
            if (a != b) {
                return false;
            }
            n -= 2;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Problem9 prob = new Problem9();
        System.out.println(prob.isPalindrome(101011));
    }
}
