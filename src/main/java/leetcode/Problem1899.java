package leetcode;

/**
 * https://leetcode.com/problems/merge-triplets-to-form-target-triplet/
 */
public class Problem1899 {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] valid = new boolean[3];
        outer:
        for (int[] triplet : triplets) {
            boolean[] tmp = new boolean[3];
            for (int i = 0; i < triplet.length; i++) {
                if (triplet[i] > target[i]) {
                    continue outer;
                } else if (triplet[i] == target[i]) {
                    tmp[i] = true;
                }
            }
            int validCount = 0;
            for (int i = 0; i < tmp.length; i++) {
                valid[i] |= tmp[i];
                if (valid[i]) {
                    validCount++;
                }
            }
            if (validCount == 3) {
                return true;
            }
        }
        return false;
    }
}
