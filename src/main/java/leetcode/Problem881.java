package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        boolean[] visited = new boolean[people.length];
        for (int i = 0; i < people.length; i++) {
            if (visited[i]) {
                continue;
            }
            int index = Arrays.binarySearch(people, i, people.length, limit - people[i]);
            if (index < 0) {
                index = -index - 1;
                if (index == visited.length) {
                    index--;
                }
            } else {
                int val = people[index];
                while (index < people.length && val == people[index]) {
                    index++;
                }
                index--;
            }
            while (i < index) {
                if (!visited[index]) {
                    if (limit - (people[i] + people[index]) >= 0) {
                        visited[index] = true;
                        break;
                    }
                }
                index--;
            }
            count++;
        }
        return count;
    }
}
