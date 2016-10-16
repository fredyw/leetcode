package leetcode;

/**
 * https://leetcode.com/problems/add-strings/
 */
public class Problem415 {
    public String addStrings(String num1, String num2) {
        boolean carry = false;
        StringBuilder result = new StringBuilder();
        int i;
        int j;
        for (i = num1.length() - 1, j = num2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int a = num1.charAt(i) - 48;
            int b = num2.charAt(j) - 48;
            int sum = (a + b) + ((carry) ? 1 : 0);
            result.append(sum % 10);
            if (sum >= 10) {
                carry = true;
            } else {
                carry = false;
            }
        }
        if (i >= 0) {
            for(; i >= 0; i--) {
                int a = num1.charAt(i) - 48;
                int sum = a + ((carry) ? 1 : 0);
                result.append(sum % 10);
                if (sum >= 10) {
                    carry = true;
                } else {
                    carry = false;
                }
            }
        }
        if (j >= 0) {
            for (; j >= 0; j--) {
                int a = num2.charAt(j) - 48;
                int sum = a + ((carry) ? 1 : 0);
                result.append(sum % 10);
                if (sum >= 10) {
                    carry = true;
                } else {
                    carry = false;
                }
            }
        }
        if (carry) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
