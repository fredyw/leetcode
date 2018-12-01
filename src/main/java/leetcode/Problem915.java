package leetcode;

/**
 * https://leetcode.com/problems/partition-array-into-disjoint-intervals/
 */
public class Problem915 {
    public int partitionDisjoint(int[] A) {
        int minIdx = 0;
        int maxIdx = 0;
        boolean smaller = true;
        int i = 1;
        int answer = 1;
        while (i < A.length) {
            if (smaller) {
                while (i < A.length && A[i] >= A[minIdx]) {
                    if (A[minIdx] > A[i]) {
                        minIdx = i;
                    }
                    if (A[maxIdx] < A[i]) {
                        maxIdx = i;
                    }
                    i++;
                }
            } else {
                while (i < A.length && A[i] < A[maxIdx]) {
                    if (A[minIdx] > A[i]) {
                        minIdx = i;
                    }
                    if (A[maxIdx] < A[i]) {
                        maxIdx = i;
                    }
                    i++;
                }
                answer = i;
            }
            smaller = !smaller;
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem915 prob = new Problem915();
//        System.out.println(prob.partitionDisjoint(new int[]{5, 0, 3, 8, 6})); // 3
//        System.out.println(prob.partitionDisjoint(new int[]{5, 0, 3, 6, 8})); // 3
//        System.out.println(prob.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12})); // 4
//        System.out.println(prob.partitionDisjoint(new int[]{1, 1, 1, 0, 6, 12, 3, 13})); // 4
//        System.out.println(prob.partitionDisjoint(new int[]{4, 10, 6, 2, 8, 12})); // 5
//        System.out.println(prob.partitionDisjoint(new int[]{5, 5, 3, 8, 2, 10, 9})); // 5
//        System.out.println(prob.partitionDisjoint(new int[]{1, 1})); // 1
//        System.out.println(prob.partitionDisjoint(new int[]{1, 1, 1, 2, 2, 2})); // 1
        System.out.println(prob.partitionDisjoint(new int[]{90, 47, 69, 10, 43, 92, 31, 73, 61, 97})); // 9
    }
}
