package leetcode;

/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 */
public class Problem984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder answer = new StringBuilder();
        int a = A;
        int b = B;
        while (a > 0 && b > 0) {
            if (A >= B) {
                if (a > 0) {
                    answer.append("a");
                    a--;
                }
                if (a > 0) {
                    answer.append("a");
                    a--;
                }
                if (b > 0) {
                    answer.append("b");
                    b--;
                }
            } else {
                if (b > 0) {
                    answer.append("b");
                    b--;
                }
                if (b > 0) {
                    answer.append("b");
                    b--;
                }
                if (a > 0) {
                    answer.append("a");
                    a--;
                }
            }
        }
        int size = answer.charAt(answer.length() - 1) == 'a' ? 1 : 2;
        for (int i = 0; i < size; i++) {
            if (a > 0) {
                answer.append("a");
                a--;
            }
        }
        size = answer.charAt(answer.length() - 1) == 'b' ? 1 : 2;
        for (int i = 0; i < size; i++) {
            if (b > 0) {
                answer.append("b");
                b--;
            }
        }
        if (a > 0) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < answer.length(); i++) {
                ans.append(answer.charAt(i));
                if (a > 0 && answer.charAt(i) == 'b') {
                    ans.append("a");
                    a--;
                }
            }
            return ans.toString();
        }
        if (b > 0) {
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < answer.length(); i++) {
                ans.append(answer.charAt(i));
                if (b > 0 && answer.charAt(i) == 'a') {
                    ans.append("b");
                    b--;
                }
            }
            return ans.toString();
        }
        return answer.toString();
    }
}
