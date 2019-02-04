package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 */
public class Problem842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> answer = new ArrayList<>();
        if (S.length() < 3) {
            return answer;
        }
        for (int i = 1; i <= S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                answer.add(Integer.valueOf(S.substring(0, i)));
                if (splitIntoFibonacci(S, 0, i, i, j, answer) && answer.size() >= 3) {
                    return answer;
                } else {
                    answer.clear();
                }
            }
        }
        return answer;
    }

    private static boolean splitIntoFibonacci(String s, int i, int j, int k, int l, List<Integer> answer) {
        if (l == s.length()) {
            answer.add(Integer.valueOf(s.substring(k, l)));
            return true;
        }
        int int1 = Integer.parseInt(s.substring(i, j));
        int int2 = Integer.parseInt(s.substring(k, l));
        long sum = int1 + int2;
        if (sum > Integer.MAX_VALUE) {
            return false;
        }
        String sumStr = Long.toString(sum);
        boolean found = false;
        if (l + sumStr.length() <= s.length() && sumStr.equals(s.substring(l, l + sumStr.length()))) {
            answer.add(int2);
            found = splitIntoFibonacci(s, k, l, l, l + sumStr.length(), answer);
            if (!found) {
                answer.remove(answer.size() - 1);
            }
        }
        return found;
    }

    public static void main(String[] args) {
        Problem842 prob = new Problem842();
//        System.out.println(prob.splitIntoFibonacci("123456579")); // [123,456,579]
//        System.out.println(prob.splitIntoFibonacci("11235813")); // [1,1,2,3,5,8,13]
//        System.out.println(prob.splitIntoFibonacci("112358130")); // []
//        System.out.println(prob.splitIntoFibonacci("0123")); // []
//        System.out.println(prob.splitIntoFibonacci("1101111")); // [110, 1, 111]
//        System.out.println(prob.splitIntoFibonacci("1")); // []
//        System.out.println(prob.splitIntoFibonacci("1")); // []
        System.out.println(prob.splitIntoFibonacci("14748364721")); // []
    }
}
