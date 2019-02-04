package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/numbers-with-same-consecutive-differences/
 */
public class Problem967 {
    public int[] numsSameConsecDiff(int N, int K) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= 9; i++) {
            set.addAll(numsSameConsecDiff(N, K, i).stream()
                .filter(e -> e.length() == 1 || (e.length() > 1 && !e.startsWith("0")))
                .map(Integer::valueOf).collect(Collectors.toList()));
        }
        int[] answer = new int[set.size()];
        int i = 0;
        for (int s : set) {
            answer[i++] = s;
        }
        Arrays.sort(answer);
        return answer;
    }

    private static List<String> numsSameConsecDiff(int n, int k, int i) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        if (i + k <= 9) {
            List<String> l = numsSameConsecDiff(n - 1, k, i + k);
            if (l.isEmpty()) {
                list.add("" + (i + k));
            } else {
                for (String s : l) {
                    list.add((i + k) + s);
                }
            }
        }
        if (i - k >= 0) {
            List<String> l = numsSameConsecDiff(n - 1, k, i - k);
            if (l.isEmpty()) {
                list.add("" + (i - k));
            } else {
                for (String s : l) {
                    list.add((i - k) + s);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Problem967 prob = new Problem967();
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(3, 7))); // [181,292,707,818,929]
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(2, 1))); // [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(3, 3))); // [141,147,252,258,303,363,369,414,474,525,585,630,636,696,741,747,852,858,963,969]
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(9, 9))); // [909090909]
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(9, 1))); // [909090909]
//        System.out.println(Arrays.toString(prob.numsSameConsecDiff(1, 0))); // [0,1,2,3,4,5,6,7,8,9]
        System.out.println(Arrays.toString(prob.numsSameConsecDiff(1, 6))); // [0,1,2,3,4,5,6,7,8,9]
    }
}
