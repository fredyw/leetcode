package leetcode;

/**
 * https://leetcode.com/problems/number-complement/
 */
public class Problem476 {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (num >> i == 0) {
                break;
            }
            int b = (num >> i) & 1;
            result |= ((b == 0) ? 1 : 0) << i;
        }
        return result;
    }
}
