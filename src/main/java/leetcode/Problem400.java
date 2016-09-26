package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/nth-digit/
 */
public class Problem400 {
    public int findNthDigit(int n) {
        List<Range> ranges = new ArrayList<>();
        long from = 1;
        long to = 9;
        long fromSeq = from;
        long toSeq = 9;
        int multiplier = 1;
        ranges.add(new Range(from, to, fromSeq, toSeq, multiplier));
        for (int i = 1; i <= 10; i++) {
            fromSeq = toSeq + 1;
            from *= 10;
            to = (to * 10) + 9;
            multiplier = (i + 1);
            toSeq += ((to - from + 1) * multiplier);
            ranges.add(new Range(from, to, fromSeq, toSeq, multiplier));
        }

        for (Range range : ranges) {
            if (range.fromSeq <= n && n <= range.toSeq) {
                long val = range.from + ((n - range.fromSeq) / range.multiplier);
                int mod = (int) (n - range.fromSeq) % range.multiplier;
                String str = Long.toString(val);
                return Integer.parseInt("" + str.charAt(mod));
            }
        }
        return 0;
    }

    private static class Range {
        private final long from;
        private final long to;
        private final long fromSeq;
        private final long toSeq;
        private final int multiplier;

        public Range(long from, long to, long fromSeq, long toSeq, int multiplier) {
            this.from = from;
            this.to = to;
            this.fromSeq = fromSeq;
            this.toSeq = toSeq;
            this.multiplier = multiplier;
        }
    }
}
