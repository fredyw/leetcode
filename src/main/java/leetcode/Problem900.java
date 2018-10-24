package leetcode;

/**
 * https://leetcode.com/problems/rle-iterator/
 */
public class Problem900 {
    private static class RLEIterator {
        private final int[] a;
        private int index;

        public RLEIterator(int[] A) {
            a = A;
        }

        public int next(int n) {
            if (index >= a.length) {
                return -1;
            }
            int value = a[index + 1];
            n -= a[index];
            if (n < 0) {
                a[index] = n * -1;
            } else if (n == 0) {
                a[index] = 0;
                index += 2;
            } else {
                a[index] = 0;
                while (n >= 0) {
                    index += 2;
                    if (index >= a.length) {
                        return -1;
                    }
                    n -= a[index];
                    value = a[index + 1];
                    if (n < 0) {
                        a[index] = n * -1;
                        break;
                    } else if (n == 0) {
                        a[index] = 0;
                        index += 2;
                        break;
                    }
                }
            }
            return value;
        }
    }
}
