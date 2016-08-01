package leetcode;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class Problem278 {
    public static class VersionControl {
        public boolean isBadVersion(int version) {
            if (version >= 1) {
                return true;
            }
            return false;
        }
    }

    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;
            while (left <= right) {
                int mid = (int) (((long) left + (long) right) / 2);
                if (isBadVersion(mid)) {
                    // go left
                    right = mid - 1;
                } else {
                    // go right
                    left = mid + 1;
                }
                if (mid - 1 >= 1) {
                    boolean b = isBadVersion(mid - 1) ^ isBadVersion(mid);
                    if (b) {
                        return mid;
                    }
                }
                if (mid + 1 <= n) {
                    boolean b = isBadVersion(mid + 1) ^ isBadVersion(mid);
                    if (b) {
                        return mid + 1;
                    }
                }
            }
            return left;
        }
    }
}
