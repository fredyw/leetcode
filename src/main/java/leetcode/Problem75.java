package leetcode;

/**
 * https://leetcode.com/problems/sort-colors/
 */
public class Problem75 {
    public void sortColors(int[] nums) {
        // using counting sort
        int[] aux = new int[nums.length];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = nums[i];
        }
        int size = 3;
        int[] count = new int[size];
        for (int i = 0; i < aux.length; i++) {
            count[aux[i]] += 1;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i-1] + count[i];
        }
        for (int i = aux.length-1; i >= 0; i--) {
            int val = aux[i];
            count[val]--;
            int idx = count[val];
            nums[idx] = val;
        }
    }
}
