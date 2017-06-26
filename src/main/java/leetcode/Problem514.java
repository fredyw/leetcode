package leetcode;

/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class Problem514 {
    public int findRotateSteps(String ring, String key) {
        // TODO
        return 0;
    }

    private static int findRotateSteps(String ring, String key, int idx) {
        int count1 = 0;
        int i = idx;
        while (key.charAt(idx) != ring.charAt(i)) {
            i++;
            if (i == ring.length()) {
                i = 0;
            }
            count1++;
        }
        int count2 = 0;
        int j = idx;
        while (key.charAt(idx) != ring.charAt(j)) {
            j--;
            if (j == -1) {
                j = ring.length() - 1;
            }
            count2++;
        }
        int min = Math.min(count1, count2);
        return min;
    }

    public static void main(String[] args) {
        Problem514 prob = new Problem514();
        System.out.println(prob.findRotateSteps("godding", "gd")); // 4
        System.out.println(prob.findRotateSteps("godding", "gdo")); // 6
    }
}
