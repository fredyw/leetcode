package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 */
public class Problem1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                if ((veganFriendly == 1 && restaurant[2] == veganFriendly) || veganFriendly == 0) {
                    list.add(restaurant);
                }
            }
        }
        Collections.sort(list, (a, b) -> {
            int cmp = b[1] - a[1];
            if (cmp == 0) {
                return b[0] - a[0];
            }
            return cmp;
        });
        return list.stream().map(a -> a[0]).collect(Collectors.toList());
    }
}
