package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/shopping-offers/
 */
public class Problem638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return lowestPrice(price, special, needs);
    }

    private static int lowestPrice(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {
        int min = Integer.MAX_VALUE;
        for (List<Integer> special : specials) {
            int specialPrice = special.get(special.size() - 1);
            // exclude the last element
            boolean foundSpecial = true;
            for (int i = 0; i < special.size() - 1; i++) {
                if (needs.get(i) - special.get(i) < 0) {
                    foundSpecial = false;
                    break;
                }
            }
            if (foundSpecial) {
                for (int i = 0; i < special.size() - 1; i++) {
                    needs.set(i, needs.get(i) - special.get(i));
                }
                min = Math.min(min, lowestPrice(prices, specials, needs));
                // backtracking
                for (int i = 0; i < special.size() - 1; i++) {
                    needs.set(i, needs.get(i) + special.get(i));
                }
            }
        }
        int total = 0;
        for (int i = 0; i < prices.size(); i++) {
            int price = prices.get(i);
            int num = needs.get(i);
            total += (price * num);
        }
        min = Math.min(min, total);
        return min;
    }

    public static void main(String[] args) {
        Problem638 prob = new Problem638();
        System.out.println(prob.shoppingOffers(
            Arrays.asList(2, 5),
            Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
            Arrays.asList(3, 2))); // 14
//        System.out.println(prob.shoppingOffers(
//            Arrays.asList(2, 3, 4),
//            Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
//            Arrays.asList(1, 2, 1))); // 11
    }
}
