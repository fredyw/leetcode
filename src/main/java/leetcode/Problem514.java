package leetcode;

/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class Problem514 {
    public int findRotateSteps(String ring, String key) {
        int[][] memo = new int[ring.length()][key.length()];
        for (int i = 0; i < ring.length(); i++) {
           for (int j = 0; j < key.length(); j++) {
               memo[i][j] = -1;
           }
        }
        return findRotateSteps(ring, key, 0, 0, memo);
    }

    private static int findRotateSteps(String ring, String key, int keyIdx, int startIdx, int[][] memo) {
        if (keyIdx == key.length()) {
            return 0;
        }
        if (memo[startIdx][keyIdx] != -1) {
            return memo[startIdx][keyIdx];
        }
        int count1 = 1;
        int i = startIdx;
        while (key.charAt(keyIdx) != ring.charAt(i)) {
            i++;
            if (i == ring.length()) {
                i = 0;
            }
            count1++;
        }

        int count2 = 1;
        int j = startIdx;
        while (key.charAt(keyIdx) != ring.charAt(j)) {
            j--;
            if (j == -1) {
                j = ring.length() - 1;
            }
            count2++;
        }
        int a = findRotateSteps(ring, key, keyIdx + 1, i, memo) + count1;
        int b = findRotateSteps(ring, key, keyIdx + 1, j, memo) + count2;
        int min = Math.min(a, b);
        memo[startIdx][keyIdx] = min;
        return min;
    }
}
