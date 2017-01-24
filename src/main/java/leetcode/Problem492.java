package leetcode;

/**
 * https://leetcode.com/problems/construct-the-rectangle/
 */
public class Problem492 {
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        double sqrt = Math.sqrt(area);
        int i = (int) sqrt;
        while (i <= area) {
            double a = area / (double) i;
            int j = (int) a;
            if (a == j) {
                result[0] = Math.max(j, i);
                result[1] = Math.min(j, i);
                break;
            }
            i++;
        }
        return result;
    }
}
