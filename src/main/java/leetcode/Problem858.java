package leetcode;

/**
 * https://leetcode.com/problems/mirror-reflection/
 */
public class Problem858 {
    public int mirrorReflection(int p, int q) {
        if (q == 0) {
            return 0;
        }
        if (p == q) {
            return 1;
        }
        int a = q;
        boolean right = true;
        boolean zero;
        while (true) {
            a += q;
            right = !right;
            zero = (a / p) % 2 == 0;
            if (a % p == 0) {
                break;
            }
        }
        if (right) {
            if (zero) {
                return 0;
            }
            return 1;
        }
        return 2;
    }
}
