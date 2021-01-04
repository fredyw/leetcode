package leetcode;

/**
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class Problem1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1710 prob = new Problem1710();
        System.out.println(prob.maximumUnits(new int[][]{
            {1,3},{2,2},{3,1}
        }, 3)); // 8
        System.out.println(prob.maximumUnits(new int[][]{
            {5,10},{2,5},{4,7},{3,9}
        }, 10)); // 91
    }
}
