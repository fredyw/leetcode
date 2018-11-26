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
            int newLimit = limit - people[i];
            int n = 1;
            for (int j = people.length - 1; j > i; j--) {
                if (visited[j]) {
                    continue;
                }
                if (newLimit - people[j] >= 0) {
                    n++;
                    newLimit -= people[j];
                    visited[j] = true;
                    // The boat can only carry 2 people.
                    if (newLimit == 0 || n == 2) {
                        break;
                    }
                }
            }
            count++;
            visited[i] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem881 prob = new Problem881();
        System.out.println(prob.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(prob.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4, 2}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 2, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{21, 40, 16, 24, 30}, 50)); // 3
        System.out.println(prob.numRescueBoats(new int[]{
            2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)); // 11
    }
}
