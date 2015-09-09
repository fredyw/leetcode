package leetcode;

/**
 * https://leetcode.com/problems/first-bad-version/
 */
public class Problem278 {
    public static class VersionControl {
        public boolean isBadVersion(int version) {
            if (version <= 4) {
                return true;
            }
            return false;
        }
    }
    
    public static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            return 0;
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstBadVersion(10));
    }
}
