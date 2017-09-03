package leetcode;

/**
 * https://leetcode.com/problems/largest-palindrome-product/
 */
public class Problem479 {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
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
        long max = largest * largest;
        String maxStr = Long.toString(max);
        long maxSub = Long.parseLong(maxStr.substring(0, maxStr.length() / 2));
        while (true) {
            String first = Long.toString(maxSub);
            String second = new StringBuilder("" + maxSub).reverse().toString();
            String str = first + second;
            if (isPalindrome(str)) {
                long l = Long.parseLong(str);
                for (long j = largest; j >= smallest; j--) {
                    long div = l / j;
                    if (div > max || j * j < l) {
                        break;
                    }
                    long mod = l % j;
                    if (mod == 0 && Long.toString(div).length() == n) {
                        return (int) (l % 1337);
                    }
                }
            }
            maxSub--;
        }
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
