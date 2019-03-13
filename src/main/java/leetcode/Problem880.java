package leetcode;

/**
 * https://leetcode.com/problems/decoded-string-at-index/
 */
public class Problem880 {
    public String decodeAtIndex(String S, int K) {
        String answer = "";
        int size = 0;
        outer:
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) >= 'a' && S.charAt(i) <= 'z') {
                answer += S.charAt(i);
                size++;
            } else {
                size = 0;
                int repeat = S.charAt(i) - '0';
                String tmp = "";
                for (int j = 0; j < repeat; j++) {
                    tmp += answer;
                    size += answer.length();
                    if (size > K) {
                        answer = tmp;
                        break outer;
                    }
                }
                answer = tmp;
            }
            if (size > K) {
                break;
            }
        }
        return "" + answer.charAt(K - 1);
    }

    public static void main(String[] args) {
        Problem880 prob = new Problem880();
//        System.out.println(prob.decodeAtIndex("leet2code3", 10)); // o
//        System.out.println(prob.decodeAtIndex("ha22", 5)); // h
//        System.out.println(prob.decodeAtIndex("hello23", 10)); // o
//        System.out.println(prob.decodeAtIndex("a2345678999999999999999", 1)); // a
        System.out.println(prob.decodeAtIndex("a2345678999999999999999", 1000000000)); // a
    }
}
