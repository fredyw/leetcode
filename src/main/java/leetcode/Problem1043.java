package leetcode;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class Problem1043 {
    public int maxSumAfterPartitioning(int[] A, int K) {
        return maxSumAfterPartitioning(A, K, 0);
    }

    private static int maxSumAfterPartitioning(int[] array, int k, int index) {
        if (index >= array.length) {
            return 0;
        }
        int answer = array[index];
        for (int i = 1; i < k; i++) {
            int val = 0;
            if (index + i >= array.length) {
                break;
            }
            int max = 0;
            for (int j = index; j < index + i; j++) {
                max = Math.max(max, array[j]);
            }
            val = maxSumAfterPartitioning(array, k, index + i) + (max * (i + 1));
            answer = Math.max(answer, val);
        }
        return answer;
    }

    public static void main(String[] args) {
        Problem1043 prob = new Problem1043();
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 2, 3, 4}, 1)); // 10
        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 2, 3, 4}, 3)); // 13
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3)); // 84
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 10, 2, 5, 9}, 3)); // 84
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{1, 15, 7, 10, 2, 5, 9}, 4)); // 87
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{10, 15, 7, 9, 2, 5, 1}, 4)); // 81
//        System.out.println(prob.maxSumAfterPartitioning(new int[]{10, 15, 7, 9, 2, 5, 1}, 2)); // 68
    }
}
