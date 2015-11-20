package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/
 */
public class Problem166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        long num = Math.abs((long) numerator);
        long denom = Math.abs((long) denominator);
        long quotient = num / denom;
        num = num - (quotient * denom);
        sb.append(quotient);
        while (num > denom) {
            quotient = num / denom;
            sb.append(quotient);
            num = num - (quotient * denom);
        }
        if (num > 0) {
            sb.append(".");
            Map<Long, Integer> map = new HashMap<>();
            StringBuilder tmp = new StringBuilder();
            int idx = 0;
            while (num > 0) {
                if (!map.containsKey(num)) {
                    map.put(num, idx);
                    num = num * 10;
                    quotient = num / denom;
                    num = num - (quotient * denom);
                    idx++;
                } else {
                    int endIdx = map.get(num);
                    sb.append(tmp.substring(0, endIdx));
                    sb.append("(").append(tmp.substring(endIdx)).append(")");
                    return sb.toString();
                }
                tmp.append(quotient);
            }
            sb.append(tmp);
        }
        return sb.toString();
    }
}
