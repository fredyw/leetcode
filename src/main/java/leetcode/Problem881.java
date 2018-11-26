package leetcode;

/**
 * https://leetcode.com/problems/boats-to-save-people/
 */
public class Problem881 {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        boolean[] visited = new boolean[people.length];
        for (int i = 0; i < people.length; i++) {
            if (visited[i]) {
                continue;
            }
            int l = limit - people[i];
            for (int j = i + 1; j < people.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (l - people[j] >= 0) {
                    l -= people[j];
                    visited[j] = true;
                    if (l == 0) {
                        break;
                    }
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem881 prob = new Problem881();
//        System.out.println(prob.numRescueBoats(new int[]{1, 2}, 3)); // 1
//        System.out.println(prob.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
//        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
//        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 4, 2}, 5)); // 4
//        System.out.println(prob.numRescueBoats(new int[]{3, 5, 3, 2, 4}, 5)); // 4
        System.out.println(prob.numRescueBoats(new int[]{21, 40, 16, 24, 30}, 50)); // 3
    }
}
