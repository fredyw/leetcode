package leetcode;

/**
 * https://leetcode.com/problems/replace-the-substring-for-balanced-string/
 */
public class Problem1234 {
    public int balancedString(String s) {
        int q = 0;
        int w = 0;
        int e = 0;
        int r = 0;
        int n = s.length() / 4;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') {
                q++;
            } else if (s.charAt(i) == 'W') {
                w++;
            } else if (s.charAt(i) == 'E') {
                e++;
            } else {
                r++;
            }
            startIndex = i;
            if (q > n || w > n || e > n || r > n) {
                if (q > n) {
                    q--;
                } else if (w > n) {
                    w--;
                } else if (e > n) {
                    e--;
                } else {
                    r--;
                }
                break;
            }
        }
        int endIndex = 0;
        for (int i = s.length() - 1; i >= startIndex; i--) {
            if (s.charAt(i) == 'Q') {
                q++;
            } else if (s.charAt(i) == 'W') {
                w++;
            } else if (s.charAt(i) == 'E') {
                e++;
            } else {
                r++;
            }
            endIndex = i;
            if (q > n || w > n || e > n || r > n) {
                if (q > n) {
                    q--;
                } else if (w > n) {
                    w--;
                } else if (e > n) {
                    e--;
                } else {
                    r--;
                }
                break;
            }
        }
        return endIndex - startIndex + 1;
    }

    public static void main(String[] args) throws Exception {
        Problem1234 prob = new Problem1234();
        System.out.println(prob.balancedString("QWER")); // 0
        System.out.println(prob.balancedString("QQWE")); // 1
        System.out.println(prob.balancedString("QQQW")); // 2
        System.out.println(prob.balancedString("QQQQ")); // 3
        System.out.println(prob.balancedString("WQWRQQQW")); // 3
        System.out.println(prob.balancedString("WWEQERQWQWWRWWERQWEQ")); // 4
        System.out.println(prob.balancedString("QQQWEEER")); // 3
    }
}
