package leetcode;

/**
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
public class Problem1287 {
    public int findSpecialInteger(int[] arr) {
        int n = (int) Math.ceil(arr.length * 0.25);
        int answer = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                count = 0;
            } else {
                count++;
            }
            if (count >= n) {
                return arr[i];
            }
        }
        return arr[arr.length - 1];
    }
}
