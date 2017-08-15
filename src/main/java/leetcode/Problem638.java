package leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/shopping-offers/
 */
public class Problem638 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // TODO
        return 0;
    }

    private static void lowestPrice(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {
        for (List<Integer> special : specials) {
            int specialPrice = special.get(special.size() - 1);
            // exclude the last element
            boolean foundSpecial = true;
            for (int i = 0; i < special.size() - 1; i++) {
                if (needs.get(0) - special.get(i) < 0) {
                    foundSpecial = false;
                    break;
                }
            }
            if (foundSpecial) {
                for (int i = 0; i < special.size() - 1; i++) {
                    needs.set(i, needs.get(0) - special.get(i));
                }
            }
            lowestPrice(prices, specials, needs);
        }
    }

    public static void main(String[] args) {
        Problem638 prob = new Problem638();
        System.out.println(prob.shoppingOffers(
            Arrays.asList(2, 5),
            Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)),
            Arrays.asList(3, 2))); // 14
        System.out.println(prob.shoppingOffers(
            Arrays.asList(2, 3, 4),
            Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)),
            Arrays.asList(1, 2, 1))); // 11
    }
}
