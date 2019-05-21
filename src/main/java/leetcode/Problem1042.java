package leetcode;

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
        for (int[] path : paths) {
            int a = path[0];
            int b = path[1];
            set[a].add(b);
            set[b].add(a);
        }
        int[] answer = new int[N];
        gardenNoAdj(answer, set, 0);
        return answer;
    }

    private static boolean gardenNoAdj(int[] answer, Set<Integer>[] set, int index) {
        if (index == answer.length) {
            return true;
        }
        for (int i = 1; i <= 4; i++) {
            answer[index] = i;
            if (isValid(answer, set, index) && gardenNoAdj(answer, set, index + 1)) {
                break;
            }
        }
        return true;
    }

    private static boolean isValid(int[] answer, Set<Integer>[] set, int index) {
        Set<Integer> adjs = set[index + 1];
        for (int adj : adjs) {
            if (answer[index] == answer[adj - 1]) {
                return false;
            }
        }
        return true;
    }
}
