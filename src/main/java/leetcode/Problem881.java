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

    public static void main(String[] args) {
        Problem881 prob = new Problem881();
        System.out.println(prob.numRescueBoats(new int[]{2, 2}, 6)); // 1
        System.out.println(prob.numRescueBoats(new int[]{2, 4}, 5)); // 2
        System.out.println(prob.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(prob.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4, 2}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 2, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{21, 40, 16, 24, 30}, 50)); // 3
        System.out.println(prob.numRescueBoats(new int[]{
            2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)); // 11
        System.out.println(prob.numRescueBoats(
            new int[]{3, 8, 4, 9, 2, 2, 7, 1, 6, 10, 6, 7, 1, 7, 7, 6, 4, 4, 10, 1}, 10)); // 11
    }
}
