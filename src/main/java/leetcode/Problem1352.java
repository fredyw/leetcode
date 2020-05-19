package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/product-of-the-last-k-numbers/
 */
public class Problem1352 {
    static class ProductOfNumbers {
        private final List<Integer> list = new ArrayList<>();

        public ProductOfNumbers() {
        }

        public void add(int num) {
            if (num == 0) {
                list.clear();
            } else if (list.isEmpty()) {
                list.add(num);
            } else if (list.size() > 0) {
                if (list.get(list.size() - 1) == 0) {
                    list.clear();
                } else {
                    list.add(list.get(list.size() - 1) * num);
                }
            }
        }

        public int getProduct(int k) {
            if (k > list.size()) {
                return 0;
            } else if (k == list.size()) {
                return list.get(list.size() - 1);
            }
            return list.get(list.size() - 1) / list.get(list.size() - k - 1);
        }
    }
}
