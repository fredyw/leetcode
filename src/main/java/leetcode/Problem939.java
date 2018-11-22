package leetcode;

/**
 * https://leetcode.com/problems/minimum-area-rectangle/
 */
public class Problem939 {
    public int minAreaRect(int[][] points) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem939 prob = new Problem939();
        System.out.println(prob.minAreaRect(new int[][]{
            {1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}
        })); // 4
        System.out.println(prob.minAreaRect(new int[][]{
            {1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}
        })); // 2
    }
}
