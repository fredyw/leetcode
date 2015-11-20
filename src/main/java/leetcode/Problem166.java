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
        long num = Math.abs(numerator);
        long denom = Math.abs(denominator);
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

    public static void main(String[] args) {
        Problem166 prob = new Problem166();
//        System.out.println(prob.fractionToDecimal(-1, 2)); // -0.5
//        System.out.println(prob.fractionToDecimal(1, -2)); // -0.5
//        System.out.println(prob.fractionToDecimal(-1, -2)); // 0.5
//        System.out.println(prob.fractionToDecimal(1, 2)); // 0.5
//        System.out.println(prob.fractionToDecimal(2, 1)); // 2
//        System.out.println(prob.fractionToDecimal(2, 3)); // 0.(6)
//        System.out.println(prob.fractionToDecimal(22, 7)); // 3.(142857)
//        System.out.println(prob.fractionToDecimal(1, 400)); // 0.0025
//        System.out.println(prob.fractionToDecimal(1, 9)); // 0.(1)
//        System.out.println(prob.fractionToDecimal(1, 3)); // 0.(3)
//        System.out.println(prob.fractionToDecimal(9, 11)); // 0.(81)
//        System.out.println(prob.fractionToDecimal(7, 12)); // 0.58(3)
//        System.out.println(prob.fractionToDecimal(700, 12)); // 58.(3)
//        System.out.println(prob.fractionToDecimal(1, 81)); // 0.(0123456798)
//        System.out.println(prob.fractionToDecimal(1, 214748364)); // 0.00(000000465661289042462740251655654056577585848337359161441621040707904997124914069194026549138227660723878669455195477065427143370461252966751355553982241280310754777158628319049732085502639731402098131932683780538602845887105337854867197032523144157689601770377165713821223802198558308923834223016478952081795603341592860749337303449725)
        System.out.println(prob.fractionToDecimal(-1, -2147483648)); // 0.0000000004656612873077392578125
    }
}
