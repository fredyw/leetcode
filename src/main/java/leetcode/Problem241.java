package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 */
public class Problem241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        return result;
    }

    private List<Integer> generate(List<Integer> list) {
        if (list.size() == 1) {
            List<Integer> newList = new ArrayList<>();
            newList.add(list.get(0));
            return newList;
        }
        if (list.size() == 2) {
            List<Integer> newList = new ArrayList<>();
            newList.add(list.get(0) + list.get(1));
            return newList;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> left = generate(list.subList(0, i));
            List<Integer> right = generate(list.subList(i + 1, list.size()));
            if (left.size() > right.size()) {
//                int total = 0;
                for (int l : left) {
                    for (int r : right) {
//                        total += l + r;
                        result.add(l + r + list.get(i));
                    }
                }
//                newList.add(total);
            } else {
//                int total = 0;
                for (int r : right) {
                    for (int l : left) {
                        result.add(l + r + list.get(i));
//                        total += l + r;
                    }
                }
//                newList.add(total);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem241 prob = new Problem241();
        System.out.println(prob.generate(Arrays.asList(1, 2, 3, 4)));
//        System.out.println(prob.diffWaysToCompute("2-1-1"));
//        System.out.println(prob.diffWaysToCompute("2*3-4*5"));
//        for (List<String> list : prob.generate(Arrays.asList("1", "2", "3", "4"))) {
//            System.out.println(list);
//        }
    }
}
