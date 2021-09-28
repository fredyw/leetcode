package leetcode;

/**
 * https://leetcode.com/problems/maximum-compatibility-score-sum/
 */
public class Problem1947 {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[] studentArray = toArray(students);
        int[] mentorArray = toArray(mentors);
        return maxCompatibilitySum(studentArray, mentorArray, students[0].length, 0,
            new boolean[studentArray.length]);
    }

    private static int[] toArray(int[][] twoDArray) {
        int[] array = new int[twoDArray.length];
        for (int i = 0; i < twoDArray.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j : twoDArray[i]) {
                sb.append(j);
            }
            array[i] = Integer.parseInt(sb.toString(), 2);
        }
        return array;
    }

    private static int maxCompatibilitySum(int[] students, int[] mentors, int bitLength,
                                           int index, boolean[] visited) {
        if (index == students.length) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < mentors.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int xor = students[index] ^ mentors[i];
            int sum = maxCompatibilitySum(students, mentors, bitLength, index + 1, visited)
                + bitLength - Integer.bitCount(xor);
            max = Math.max(max, sum);
            visited[i] = false;
        }
        return max;
    }
}