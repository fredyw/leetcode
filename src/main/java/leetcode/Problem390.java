package leetcode;

/**
 * https://leetcode.com/problems/elimination-game/
 */
public class Problem390 {
    public int lastRemaining(int n) {
        int first = 1;
        int last = n;
        int m = 1;
        boolean left = true;
        while (n > 1) {
            if (left) {
                first += m;
                if (n % 2 != 0) {
                    last -= m;
                }
            } else if (!left) {
                last -= m;
                if (n % 2 != 0) {
                    first += m;
                }
            }
            left = !left;
            n /= 2;
            m *= 2;
        }
        return (left) ? last : first;
    }
}
