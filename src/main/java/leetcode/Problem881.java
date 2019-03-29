package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            answer++;
        }
        return answer;
    }
}
