package leetcode;

/**
 * https://leetcode.com/problems/maximum-population-year/
 */
public class Problem1854 {
    public int maximumPopulation(int[][] logs) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1854 prob = new Problem1854();
        System.out.println(prob.maximumPopulation(new int[][]{
            {1993,1999},{2000,2010}
        })); // 1993
        System.out.println(prob.maximumPopulation(new int[][]{
            {1950,1961},{1960,1971},{1970,1981}
        })); // 1960
    }
}
