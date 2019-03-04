package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/max-consecutive-ones-iii/
 */
public class Problem1004 {
    public int longestOnes(int[] A, int K) {
        List<NumberCount> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (list.isEmpty()) {
                    list.add(new NumberCount(0, 1));
                    continue;
                }
                NumberCount nc = list.get(list.size() - 1);
                if (nc.number == A[i]) {
                    nc.count++;
                } else {
                    list.add(new NumberCount(0, 1));
                }
            } else {
                if (list.isEmpty()) {
                    list.add(new NumberCount(1, 1));
                    continue;
                }
                NumberCount nc = list.get(list.size() - 1);
                if (nc.number == A[i]) {
                    nc.count++;
                } else {
                    list.add(new NumberCount(1, 1));
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int max = 0;
            int count = K;
            int j = i;
            while (j < list.size()) {
                NumberCount nc = list.get(j);
                if (nc.number == 0) {
                    if (count - nc.count >= 0) {
                        count -= nc.count;
                        max += nc.count;
                    } else {
                        max += count;
                        break;
                    }
                } else {
                    max += nc.count;
                }
                j++;
            }
            answer = Math.max(answer, max);
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            int max = 0;
            int count = K;
            int j = i;
            while (j >= 0) {
                NumberCount nc = list.get(j);
                if (nc.number == 0) {
                    if (count - nc.count >= 0) {
                        count -= nc.count;
                        max += nc.count;
                    } else {
                        max += count;
                        break;
                    }
                } else {
                    max += nc.count;
                }
                j--;
            }
            answer = Math.max(answer, max);
        }
        return answer;
    }

    private static class NumberCount {
        private final int number;
        private int count;

        public NumberCount(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
