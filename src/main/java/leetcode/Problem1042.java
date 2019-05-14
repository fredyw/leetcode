package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/flower-planting-with-no-adjacent/
 */
public class Problem1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Set<Integer>[] set = new HashSet[N + 1];
        for (int i = 1; i <= N; i++) {
            set[i] = new HashSet<>();
        }
        for (int i = 1; i <= N; i++) {
            int a = paths[i][0];
            int b = paths[i][1];
            set[a].add(b);
            set[b].add(a);
        }
        int[] answer = new int[N];
        for (int i = 1; i <= N; i++) {
            // TODO
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1042 prob = new Problem1042();
        System.out.println(Arrays.toString(prob.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}}))); // [1,2,3]
//        System.out.println(Arrays.toString(prob.gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}}))); // [1,2,1,2]
//        System.out.println(Arrays.toString(prob.gardenNoAdj(4, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 3}, {2, 4}}))); // [1,2,3,4]
    }
}
