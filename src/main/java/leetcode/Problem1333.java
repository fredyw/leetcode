package leetcode;

import java.util.List;

/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 */
public class Problem1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // TODO
        return null;
    }

    public static void main(String[] args) {
        Problem1333 prob = new Problem1333();
        System.out.println(prob.filterRestaurants(
            new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}},
        1, 50, 10)); // [3,1,5]
        System.out.println(prob.filterRestaurants(
            new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}},
            0, 50, 10)); // [4,3,2,1,5]
        System.out.println(prob.filterRestaurants(
            new int[][]{{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}},
            0, 30, 3)); // [4,5]
    }
}
