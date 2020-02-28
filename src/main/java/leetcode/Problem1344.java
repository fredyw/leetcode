package leetcode;

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock/
 */
public class Problem1344 {
    public double angleClock(int hour, int minutes) {
        // Every hour is 0.5 degrees.
        double hDeg = (360 / 12) / 60.0;
        // Every minute is 6 degrees.
        double mDeg = 360 / 60.0;
        double h = hour == 12 ? 0 : hour * 5;
        double degree = (Math.abs(h - minutes) * mDeg);
        if (h < minutes) {
            degree -= minutes * hDeg;
        } else {
            degree += minutes * hDeg;
        }
        degree = Math.abs(degree);
        return Math.min(360 - degree, degree);
    }
}
