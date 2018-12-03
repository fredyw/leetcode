package leetcode;

/**
 * https://leetcode.com/problems/largest-time-for-given-digits/
 */
public class Problem949 {
    public String largestTimeFromDigits(int[] A) {
        boolean[] processed = new boolean[A.length];
        int t1 = time(A, processed, 2);
        if (t1 == -1) {
            return "";
        }
        int t2 = time(A, processed, t1 < 2 ? 9 : 3);
        if (t2 == -1) {
            return "";
        }
        int t3 = time(A, processed, 5);
        if (t3 == -1) {
            return "";
        }
        int t4 = time(A, processed, 9);
        if (t4 == -1) {
            return "";
        }
        return String.format("%d%d:%d%d", t1, t2, t3, t4);
    }

    private static int time(int[] a, boolean[] processed, int val) {
        int max = -1;
        int idx = -1;
        for (int i = 0; i < a.length; i++) {
            if (processed[i]) {
                continue;
            }
            if (a[i] <= val) {
                if (max < a[i]) {
                    idx = i;
                    max = a[i];
                }
            }
        }
        if (idx == -1) {
            return -1;
        }
        processed[idx] = true;
        return a[idx];
    }

    public static void main(String[] args) {
        Problem949 prob = new Problem949();
//        System.out.println(prob.largestTimeFromDigits(new int[]{1, 2, 3, 4})); // 23:41
//        System.out.println(prob.largestTimeFromDigits(new int[]{5, 5, 5, 5})); //
//        System.out.println(prob.largestTimeFromDigits(new int[]{5, 0, 3, 2})); // 23:50
//        System.out.println(prob.largestTimeFromDigits(new int[]{5, 0, 3, 2})); // 23:50
//        System.out.println(prob.largestTimeFromDigits(new int[]{0, 0, 0, 2})); // 23:50
//        System.out.println(prob.largestTimeFromDigits(new int[]{0, 4, 0, 0})); // 04:00
//        System.out.println(prob.largestTimeFromDigits(new int[]{0, 4, 0, 9})); // 04:00
//        System.out.println(prob.largestTimeFromDigits(new int[]{2, 3, 6, 2})); // 23:26
//        System.out.println(prob.largestTimeFromDigits(new int[]{4, 1, 0, 0})); // 14:00
        System.out.println(prob.largestTimeFromDigits(new int[]{2, 0, 6, 6})); // 06:26
    }
}
