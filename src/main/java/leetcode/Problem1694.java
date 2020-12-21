package leetcode;

/**
 * https://leetcode.com/problems/reformat-phone-number/
 */
public class Problem1694 {
    public String reformatNumber(String number) {
        String num = number.replaceAll("-", "").replaceAll("\\s", "");
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.length() % 3 == 1 && num.length() - count == 4) {
                if (answer.length() > 0) {
                    answer.append("-");
                }
                answer.append(num, i, i + 2).append("-").append(num, i + 2, i + 4);
                break;
            }
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                if (i > 0 && count % 3 == 0) {
                    answer.append("-");
                }
                answer.append(num.charAt(i));
                count++;
            }
        }
        return answer.toString();
    }
}
