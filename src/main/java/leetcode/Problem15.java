package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem15 {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                if (i >= j) {
                    continue;
                }
                int val = -(num[i] + num[j]);
                int k = Arrays.binarySearch(num, j+1, num.length, val);
                if (k < 0 || j >= k) {
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(num[i]);
                list.add(num[j]);
                list.add(num[k]);
                if (!set.contains(list)) {
                    set.add(list);
                    result.add(list);
                }
            }
        }
        return result;
    }
}
