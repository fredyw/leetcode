package leetcode;

/**
 * https://leetcode.com/problems/reformat-phone-number/
 */
public class Problem1694 {
    public String reformatNumber(String number) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1694 prob = new Problem1694();
        System.out.println(prob.reformatNumber("1-23-45 6")); // "123-456"
        System.out.println(prob.reformatNumber("123 4-567")); // "123-45-67"
        System.out.println(prob.reformatNumber("123 4-5678")); // "123-456-78"
        System.out.println(prob.reformatNumber("12")); // "12"
        System.out.println(prob.reformatNumber("--17-5 229 35-39475 ")); // "175-229-353-94-75"
    }
}
