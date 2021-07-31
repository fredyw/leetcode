package leetcode;

/**
 * https://leetcode.com/problems/sum-of-digits-of-string-after-convert/
 */
public class Problem1945 {
    public int getLucky(String s, int k) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            int n = c - 'a' + 1;
            if (n / 10 == 2) {
                sum += 2 + (n % 10);
            } else if (n / 10 == 1) {
                sum += 1 + (n % 10);
            } else {
                sum += n % 10;
            }
        }
        int answer = sum;
        String str = Integer.toString(sum);
        for (int i = 0; i < k - 1; i++) {
            sum = 0;
            for (char c : str.toCharArray()) {
                sum += c - '0';
            }
            answer = sum;
            str = Integer.toString(sum);
            if (str.length() == 1) {
                break;
            }
        }
        return answer;
    }
}
