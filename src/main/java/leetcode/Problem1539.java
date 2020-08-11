package leetcode;

/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class Problem1539 {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int i = 1;
        int j = 0;
        while (true) {
            if (j < arr.length && arr[j] == i) {
                j++;
            } else {
                count++;
                if (count == k) {
                    return i;
                }
            }
            i++;
        }
    }
}
