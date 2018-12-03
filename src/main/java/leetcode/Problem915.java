package leetcode;

/**
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */
public class Problem915 {
    public int partitionDisjoint(int[] A) {
        int prevMaxIdx = 0;
        int curMaxIdx = 0;
        int i = 1;
        int answer = 1;
        while (i < A.length) {
            while (i < A.length && A[i] < A[curMaxIdx]) {
                i++;
            }
            answer = i;
            prevMaxIdx = curMaxIdx;
            curMaxIdx = i;
            while (i < A.length && A[i] >= A[prevMaxIdx]) {
                if (A[i] > A[curMaxIdx]) {
                    curMaxIdx = i;
                }
                i++;
            }
            i++;
        }
        return answer;
    }
}
