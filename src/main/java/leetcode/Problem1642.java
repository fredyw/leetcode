package leetcode;

/**
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class Problem1642 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // TODO
        return 0;
    }

    public static void main(String[] args) {
        Problem1642 prob = new Problem1642();
        System.out.println(prob.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1)); // 4
        System.out.println(prob.furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2)); // 7
        System.out.println(prob.furthestBuilding(new int[]{14,3,19,3}, 17, 0)); // 3
    }
}
