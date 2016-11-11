package leetcode;

/**
 * https://leetcode.com/problems/number-of-boomerangs/
 */
public class Problem447 {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int distance1 = getDistance(points, i, j);
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int distance2 = getDistance(points, i, k);
                    if (distance1 == distance2) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static int getDistance(int[][] points, int i, int j) {
        int a = points[i][0] - points[j][0];
        int b = points[i][1] - points[j][1];
        return (a * a) + (b * b);
    }

    public static void main(String[] args) {
        Problem447 prob = new Problem447();
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{1, 4}, {0, 8}, {2, 8}, {4, 5}})); // 2
        System.out.println(prob.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}})); // 20
    }
}
