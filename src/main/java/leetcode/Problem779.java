package leetcode;

/**
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class Problem779 {
    public int kthGrammar(int N, int K) {
        int[] cols = new int[N];
        cols[N - 1] = K;
        for (int row = N - 2; row >= 0; row--) {
            cols[row] = (int) Math.ceil(cols[row + 1] / 2.0);
        }
        String s = "0";
        for (int row = 0; row < N; row++) {
            String tmp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    tmp += "01";
                } else {
                    tmp += "10";
                }
                if (tmp.length() >= cols[row]) {
                    break;
                }
            }
            s = tmp;
        }
        return s.charAt(K - 1) - '0';
    }

    public static void main(String[] args) {
        // 01101001
        Problem779 prob = new Problem779();
//        System.out.println(prob.kthGrammar(1, 1)); // 0
//        System.out.println(prob.kthGrammar(2, 1)); // 0
//        System.out.println(prob.kthGrammar(2, 2)); // 1
//        System.out.println(prob.kthGrammar(4, 5)); // 1
        System.out.println(prob.kthGrammar(30, 434991989)); // 1
    }
}
