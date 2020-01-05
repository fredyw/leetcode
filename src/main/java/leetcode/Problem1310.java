package leetcode;

/**
 * https://leetcode.com/problems/xor-queries-of-a-subarray/
 */
public class Problem1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] prefixXor = new int[arr.length];
        prefixXor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            answer[i] = prefixXor[to];
            if (from - 1 >= 0) {
                answer[i] ^= prefixXor[from - 1];
            }
        }
        return answer;
    }
}
