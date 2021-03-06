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
        if (d1 == d2) {
            // hypotenuse: d3
            double d4 = distance(p2, p4);
            if (!isRightAngled(d1, d4, d3)) {
                return false;
            }
            double d5 = distance(p3, p4);
            if (!isRightAngled(d2, d5, d3)) {
                return false;
            }
            return toInt(d1) == toInt(d4) && toInt(d1) == toInt(d5);
        } else if (d1 == d3) {
             // hypotenuse: d2
            double d4 = distance(p2, p3);
            if (!isRightAngled(d1, d4, d2)) {
                return false;
            }
            double d5 = distance(p4, p3);
            if (!isRightAngled(d3, d5, d2)) {
                return false;
            }
            return toInt(d1) == toInt(d4) && toInt(d1) == toInt(d5);
        } else if (d2 == d3) {
            // hypotenuse: d1
            double d4 = distance(p3, p2);
            if (!isRightAngled(d2, d4, d1)) {
                return false;
            }
            double d5 = distance(p4, p2);
            if (!isRightAngled(d3, d5, d1)) {
                return false;
            }
            return toInt(d2) == toInt(d4) && toInt(d2) == toInt(d5);
        }
        return false;
    }

    private static int toInt(double d) {
        return (int) (d * 1e6);
    }

    private static double distance(int[] p1, int[] p2) {
        // Euclidean
        return Math.sqrt(((p1[0] - p2[0]) * (p1[0] - p2[0])) + ((p1[1] - p2[1]) * (p1[1] - p2[1])));
    }

    private boolean isRightAngled(double a, double b, double c) {
        return toInt(((a * a) + (b * b))) == toInt((c * c));
    }
}
