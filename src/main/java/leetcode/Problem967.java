package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Problem967 {
    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> set = new HashSet<>();
        List<String>[][] memo = new List[N + 1][10];
        for (int i = 0; i <= 9; i++) {
            List<String> newList = new ArrayList<>();
            List<String> list = numsSameConsecDiff(N - 1, K, i, memo);
            if (list.isEmpty()) {
                String s = "" + i;
                if (s.length() == N) {
                    newList.add(s);
                }
            } else {
                for (String s : list) {
                    String s1 = i + s;
                    if (s1.length() == N) {
                        newList.add(s1);
                    }
                }
            }
            for (String s : newList) {
                if (s.length() == 1 || (s.length() > 1 && !s.startsWith("0"))) {
                    set.add(Integer.valueOf(s));
                }
            }
        }
        int[] answer = new int[set.size()];
        int i = 0;
        for (int s : set) {
            answer[i++] = s;
        }
        return answer;
    }

    private static List<String> numsSameConsecDiff(int n, int k, int i, List<String>[][] memo) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (memo[n][i] != null) {
            return memo[n][i];
        }
        List<String> list = new ArrayList<>();
        if (i + k <= 9) {
            List<String> l = numsSameConsecDiff(n - 1, k, i + k, memo);
            if (l.isEmpty()) {
                list.add("" + (i + k));
            } else {
                for (String s : l) {
                    list.add((i + k) + s);
                }
            }
        }
        if (i - k >= 0) {
            List<String> l = numsSameConsecDiff(n - 1, k, i - k, memo);
            if (l.isEmpty()) {
                list.add("" + (i - k));
            } else {
                for (String s : l) {
                    list.add((i - k) + s);
                }
            }
        }
        memo[n][i] = list;
        return list;
    }
}
