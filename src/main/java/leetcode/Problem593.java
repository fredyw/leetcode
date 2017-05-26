package leetcode;

/**
 * https://leetcode.com/problems/valid-square/
 */
public class Problem593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d1 = distance(p1, p2);
        double d2 = distance(p1, p3);
        double d3 = distance(p1, p4);
        if (d1 == 0 || d2 == 0 || d3 == 0) {
            return false;
        }
        // Pythagoras
        if (d1 == d2) {
            double d4 = Math.sqrt((d3 * d3) - (d1 * d1));
            double d5 = Math.sqrt((d3 * d3) - (d2 * d2));
            return toInt(d1) == toInt(d4) && toInt(d1) == toInt(d5);
        } else if (d1 == d3) {
            double d4 = Math.sqrt((d2 * d2) - (d1 * d1));
            double d5 = Math.sqrt((d2 * d2) - (d3 * d3));
            return toInt(d1) == toInt(d4) && toInt(d1) == toInt(d5);
        } else if (d2 == d3) {
            double d4 = Math.sqrt((d1 * d1) - (d2 * d2));
            double d5 = Math.sqrt((d1 * d1) - (d3 * d3));
            return toInt(d2) == toInt(d4) && toInt(d2) == toInt(d5);
        }
        return false;
    }

    private static int toInt(double d) {
        return (int) (d * 1e3);
    }

    private static double distance(int[] p1, int[] p2) {
        // Euclidean
        return Math.sqrt(((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1])));
    }

    public static void main(String[] args) {
        Problem593 prob = new Problem593();
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1})); // true
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 5}, new int[]{0, 1})); // false
//        System.out.println(prob.validSquare(new int[]{0, 1}, new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0})); // true
//        System.out.println(prob.validSquare(new int[]{0, 1}, new int[]{0, 0}, new int[]{1, -1}, new int[]{1, 0})); // false
//        System.out.println(prob.validSquare(new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1})); // true
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1})); // false
//        System.out.println(prob.validSquare(new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0})); // false
        System.out.println(prob.validSquare(new int[]{0, 1}, new int[]{1, 2}, new int[]{0, 2}, new int[]{0, 0})); // false
    }
}
