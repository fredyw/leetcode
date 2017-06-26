package leetcode;

/**
 * https://leetcode.com/problems/freedom-trail/
 */
public class Problem514 {
    public int findRotateSteps(String ring, String key) {
        // TODO
        return findRotateSteps(ring, key, 0, 0);
    }

    private static int findRotateSteps(String ring, String key, int keyIdx, int startIdx) {
        if (keyIdx == key.length()) {
            return 0;
        }
        int count1 = 0;
        int i = startIdx;
        if (key.charAt(keyIdx) == ring.charAt(i)) {
            count1++;
        } else {
            while (key.charAt(keyIdx) != ring.charAt(i)) {
                i++;
                if (i == ring.length()) {
                    i = 0;
                }
                count1++;
            }
        }

        int count2 = 0;
        int j = startIdx;
        if (key.charAt(keyIdx) == ring.charAt(j)) {
            count2++;
        } else {
            while (key.charAt(keyIdx) != ring.charAt(j)) {
                j--;
                if (j == -1) {
                    j = ring.length() - 1;
                }
                count2++;
            }
        }
        int min = Math.min(count1, count2);
        int a = findRotateSteps(ring, key, keyIdx + 1, i) + min;
        int b = findRotateSteps(ring, key, keyIdx + 1, j) + min;
        min = Math.min(a, b);
        return min;
    }

    public static void main(String[] args) {
        Problem514 prob = new Problem514();
        System.out.println(prob.findRotateSteps("godding", "gd")); // 4
//        System.out.println(prob.findRotateSteps("godding", "gdo")); // 6
    }
}
