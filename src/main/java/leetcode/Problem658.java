package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class Problem658 {
    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        // TODO
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Problem658 prob = new Problem658();
        System.out.println(prob.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 4, 3)); // [1,2,3,4]
        System.out.println(prob.findClosestElements(Arrays.asList(1, 2, 3, 4, 5), 4, -1)); // [1,2,3,4]
    }
}
