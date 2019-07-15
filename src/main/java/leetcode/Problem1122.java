package leetcode;

/**
 * https://leetcode.com/problems/relative-sort-array/
 */
public class Problem1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int i = 0; i < arr1.length; i++) {
            counts[arr1[i]]++;
        }
        int index = 0;
        int[] answer = new int[arr1.length];
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < counts[arr2[i]]; j++) {
                answer[index++] = arr2[i];
            }
            counts[arr2[i]] = 0;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            for (int j = 0; j < counts[i]; j++) {
                answer[index++] = i;
            }
        }
        return answer;
    }
}
