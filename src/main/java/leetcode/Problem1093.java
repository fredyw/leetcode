package leetcode;

/**
 * https://leetcode.com/problems/statistics-from-a-large-sample/
 */
public class Problem1093 {
    public double[] sampleStats(int[] count) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long size = 0;
        long sum = 0;
        int modeCount = Integer.MIN_VALUE;
        int mode = 0;
        for (int i = 0; i < count.length; i++) {
            sum += i * count[i];
            size += count[i];
            if (count[i] > 0) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
            if (modeCount < count[i]) {
                mode = i;
                modeCount = count[i];
            }
        }
        double mean = (double) sum / (double) size;
        double median = 0;
        int left = -1;
        int right = -1;
        long c = 0;
        for (int i = 0; i < count.length; i++) {
            c += count[i];
            if (size % 2 != 0) {
                if (c >= (size / 2)) {
                    median = i;
                    break;
                }
            } else {
                if (left == -1 && c >= (size / 2)) {
                    left = i;
                }
                if (right == -1 && c >= (size / 2) + 1) {
                    right = i;
                }
                if (left != -1 && right != -1) {
                    median = (double) (left + right) / (double) 2;
                    break;
                }
            }
        }
        return new double[]{min, max, mean, median, mode};
    }
}
