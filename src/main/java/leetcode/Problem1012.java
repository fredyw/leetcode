package leetcode;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class Problem1012 {
    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }
        int n = N;
        int size = 0;
        while (n > 0) {
            n >>= 1;
            size++;
        }
        int answer = ~N;
        int m = ~0;
        for (int i = 0; i < size; i++) {
            m <<= 1;
        }
        return answer & ~m;
    }
}
