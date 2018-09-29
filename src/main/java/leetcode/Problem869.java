package leetcode;

/**
 * https://leetcode.com/problems/reordered-power-of-2/
 */
public class Problem869 {
    public boolean reorderedPowerOf2(int N) {
        if (isPower2(N)) {
            return true;
        }
        String s = "" + N;
        return reorderedPowerOf2(s.toCharArray(), 0);
    }

    private static boolean reorderedPowerOf2(char[] chars, int idx) {
        if (idx == chars.length) {
            if (chars[0] == '0') {
                return false;
            }
            long n = Long.parseLong(new String(chars));
            return isPower2(n);
        }
        for (int i = idx; i < chars.length; i++) {
            swap(chars, idx, i);
            if (reorderedPowerOf2(chars, idx + 1)) {
                return true;
            }
            // Backtrack.
            swap(chars, idx, i);
        }
        return false;
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static double log2(long n) {
        return Math.log10(n) / Math.log10(2);
    }

    private static boolean isPower2(long n) {
        return Math.ceil(log2(n)) == Math.floor(log2(n));
    }
}
