package leetcode;

/**
 * https://leetcode.com/problems/largest-palindrome-product/
 */
public class Problem479 {
    public int largestPalindrome(int n) {
        StringBuilder largestStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            largestStr.append(9);
        }
        StringBuilder smallestStr = new StringBuilder();
        smallestStr.append(1);
        for (int i = 1; i < n; i++) {
            smallestStr.append(0);
        }
        long largest = Long.parseLong(largestStr.toString());
        long smallest = Long.parseLong(smallestStr.toString());
        long max = 0;
        for (long i = largest; i >= smallest; i--) {
            for (long j = largest; j >= smallest; j--) {
                long num = i * j;
                if (isPalindrome(Long.toString(num))) {
                    max = Math.max(max, num);
                }
            }
        }
        return (int) (max % 1337);
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem479 prob = new Problem479();
        System.out.println(prob.largestPalindrome(1)); // 9
        System.out.println(prob.largestPalindrome(2)); // 987
        System.out.println(prob.largestPalindrome(3)); // 123
        System.out.println(prob.largestPalindrome(4)); // 597
        System.out.println(prob.largestPalindrome(5)); // 677
        System.out.println(prob.largestPalindrome(6)); // 1218
        System.out.println(prob.largestPalindrome(7)); // 877
        System.out.println(prob.largestPalindrome(8)); // 475
    }
}
