package leetcode;

/**
 * https://leetcode.com/problems/minimum-area-rectangle-ii/
 */
public class Problem963 {
    public double minAreaFreeRect(int[][] points) {
        // https://stackoverflow.com/questions/2303278/find-if-4-points-on-a-plane-form-a-rectangle
        double answer = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (isRectangle(points[i], points[j], points[k], points[l])) {
                            double area = distance(points[i], points[j]) *
                                distance(points[j], points[k]);
                            answer = Math.min(answer, area);
                        } else if (isRectangle(points[j], points[k], points[i], points[l])) {
                            double area = distance(points[j], points[k]) +
                                distance(points[k], points[i]);
                            answer = Math.min(answer, area);
                        } else if (isRectangle(points[k], points[i], points[j], points[l])) {
                            double area = distance(points[k], points[i]) *
                                distance(points[i], points[j]);
                            answer = Math.min(answer, area);
                        }
                    }
                }
            }
        }
        return answer == Double.MAX_VALUE ? 0 : answer;
    }

    private static double distance(int[] a, int[] b) {
        return Math.sqrt(((a[0] - b[0]) * (a[0] - b[0])) + ((a[1] - b[1]) * (a[1] - b[1])));
    }

    private static boolean isRightAngle(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (b[0] - c[0]) + (b[1] - a[1]) * (b[1] - c[1]) == 0;
    }

    private static boolean isRectangle(int[] a, int[] b, int[] c, int[] d) {
        return isRightAngle(a, b, c) && isRightAngle(b, c, d) && isRightAngle(c, d, a);
    }

    public static void main(String[] args) {
        Problem963 prob = new Problem963();
//        System.out.println(prob.minAreaFreeRect(new int[][]{
//            {1, 2}, {2, 1}, {1, 0}, {0, 1}
//        })); // 2.00000
//        System.out.println(prob.minAreaFreeRect(new int[][]{
//            {0, 1}, {2, 1}, {1, 1}, {1, 0}, {2, 0}
//        })); // 1.00000
//        System.out.println(prob.minAreaFreeRect(new int[][]{
//            {0, 3}, {1, 2}, {3, 1}, {1, 3}, {2, 1}
//        })); // 0
//        System.out.println(prob.minAreaFreeRect(new int[][]{
//            {3, 1}, {1, 1}, {0, 1}, {2, 1}, {3, 3}, {3, 2}, {0, 2}, {2, 3}
//        })); // 2.00000
        System.out.println(prob.minAreaFreeRect(new int[][]{
            {0, 1}, {1, 0}, {3, 2}, {2, 3}, {0, 3}, {1, 1}, {3, 3}, {0, 2}
        })); // 3.0
    }
}
