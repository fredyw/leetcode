package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/
 */
public class Problem592 {
    public String fractionAddition(String expression) {
        List<Integer> numerators = new ArrayList<>();
        List<Integer> denominators = new ArrayList<>();
        int i = 0;
        while (i < expression.length()) {
            char ch = expression.charAt(i);
            if (ch == '-' || ch == '+') {
                // get the numerator
                i++;
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    number.append(expression.charAt(i));
                    i++;
                }
                Integer num = Integer.valueOf("" + ch + number.toString());
                numerators.add(num);
            } else if (ch == '/') {
                // get the denominator
                i++;
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    number.append(expression.charAt(i));
                    i++;
                }
                Integer denom = Integer.valueOf("" + number.toString());
                denominators.add(denom);
            } else {
                // if the expression doesn't start with a sign
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                    number.append(expression.charAt(i));
                    i++;
                }
                Integer num = Integer.valueOf("" + number.toString());
                numerators.add(num);
            }
        }
        int denom = denominators.get(0);
        for (int j = 1; j < denominators.size(); j++) {
            denom *= denominators.get(j);
        }
        int num = 0;
        for (int j = 0; j < numerators.size(); j++) {
            num += numerators.get(j) * (denom / denominators.get(j));
        }
        int gcd = Math.abs(gcd(num, denom));
        return (num / gcd) + "/" + (denom / gcd);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
