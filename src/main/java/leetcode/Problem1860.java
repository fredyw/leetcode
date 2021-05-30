package leetcode;

/**
 * https://leetcode.com/problems/incremental-memory-leak/
 */
public class Problem1860 {
    public int[] memLeak(int memory1, int memory2) {
        int[] answer = new int[3];
        int i = 1;
        int m1 = memory1;
        int m2 = memory2;
        while (m1 >= 0 && m2 >= 0) {
            if (m1 == m2 || m1 > m2) {
                m1 -= i;
            } else { // m1 < m2
                m2 -= i;
            }
            if (m1 < 0 || m2 < 0) {
                answer[0] = i;
                break;
            }
            answer[0] = i;
            answer[1] = m1;
            answer[2] = m2;
            i++;
        }
        return answer;
    }
}
