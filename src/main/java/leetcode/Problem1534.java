package leetcode;

/**
 * https://leetcode.com/problems/count-good-triplets/
 */
public class Problem1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a &&
                        Math.abs(arr[j] - arr[k]) <= b &&
                        Math.abs(arr[i] - arr[k]) <= c) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
