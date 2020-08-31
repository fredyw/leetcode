package leetcode;

/**
 * https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times/
 */
public class Problem1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0; i <= arr.length - m; i++) {
            int n = i;
            String prev = "";
            boolean found = true;
            for (int j = 0; j < k; j++) {
                String s = "";
                for (int l = 0; l < m && n < arr.length; l++) {
                    s += arr[n++];
                }
                if (!prev.isEmpty() && !s.equals(prev)) {
                    found = false;
                    break;
                }
                prev = s;
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}
