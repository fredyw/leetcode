package leetcode;

/**
 * https://leetcode.com/problems/string-without-aaa-or-bbb/
 */
public class Problem984 {
    public String strWithout3a3b(int A, int B) {
        StringBuilder answer = new StringBuilder();
        int a = A;
        int b = B;
        while (a + b > 0) {
            if (A >= B) {
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
                if (a > 0) {
                    answer.append("a");
                    a--;
                }
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Problem984 prob = new Problem984();
        System.out.println(prob.strWithout3a3b(1, 2));
        System.out.println(prob.strWithout3a3b(4, 1));
        System.out.println(prob.strWithout3a3b(3, 1));
        System.out.println(prob.strWithout3a3b(1, 3));
        System.out.println(prob.strWithout3a3b(3, 3));
        System.out.println(prob.strWithout3a3b(4, 4));
        System.out.println(prob.strWithout3a3b(4, 5));
    }
}
