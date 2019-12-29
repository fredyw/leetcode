package leetcode;

/**
 * https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 */
public class Problem1299 {
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        answer[arr.length - 1] = -1;
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            answer[i] = max;
            max = Math.max(max, arr[i]);
        }
        return answer;
    }
}
