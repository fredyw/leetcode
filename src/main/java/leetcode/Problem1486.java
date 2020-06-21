package leetcode;

/**
 * https://leetcode.com/problems/xor-operation-in-an-array/
 */
public class Problem1486 {
    public int xorOperation(int n, int start) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer ^= start + (2 * i);
        }
        return answer;
    }
}
