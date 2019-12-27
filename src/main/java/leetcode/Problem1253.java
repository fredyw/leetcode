package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class Problem1253 {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        int twoCounts = 0;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                answer.get(0).add(1);
                answer.get(1).add(1);
                twoCounts++;
            } else {
                answer.get(0).add(0);
                answer.get(1).add(0);
            }
        }
        int up = upper - twoCounts;
        int lo = lower - twoCounts;
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (up > 0) {
                    answer.get(0).set(i, 1);
                    up--;
                } else if (lo > 0) {
                    answer.get(1).set(i, 1);
                    lo--;
                } else {
                    return Collections.emptyList();
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1253 prob = new Problem1253();
//        System.out.println(prob.reconstructMatrix(2, 1, new int[]{1, 1, 1})); // [[1,1,0],[0,0,1]]
//        System.out.println(prob.reconstructMatrix(2, 3, new int[]{2,2,1,1})); // []
//        System.out.println(prob.reconstructMatrix(5, 5, new int[]{2,1,2,0,1,0,1,2,0,1})); // [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
        System.out.println(prob.reconstructMatrix(1, 4, new int[]{2,1,2,0,0,2})); // [[1,0,1,0,0,1],[1,1,1,0,0,1]]
    }
}
