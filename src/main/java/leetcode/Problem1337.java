package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class Problem1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        IndexCount[] indexCounts = new IndexCount[mat.length];
        for (int i = 0; i < mat.length; i++) {
            IndexCount ic = new IndexCount(i);
            for (int j = 0; j < mat[i].length; j++) {
                ic.count += mat[i][j];
            }
            indexCounts[i] = ic;
        }
        Arrays.sort(indexCounts, (a, b) -> {
            int cmp = Integer.compare(a.count, b.count);
            if (cmp == 0) {
                return Integer.compare(a.index, b.index);
            }
            return cmp;
        });
        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = indexCounts[i].index;
        }
        return answer;
    }

    private static class IndexCount {
        private final int index;
        private int count;

        public IndexCount(int index) {
            this.index = index;
        }
    }
}
