package leetcode;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/
 */
public class Problem787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem787 prob = new Problem787();
        System.out.println(prob.findCheapestPrice(3, new int[][]{
            {0, 1, 100}, {1, 2, 100}, {0, 2, 500}
        }, 0, 2, 1)); // 200
    }
}
