package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/gray-code/
 */
public class Problem89 {
    public List<Integer> grayCode(int n) {
        // using this algorithm
        // https://en.wikipedia.org/wiki/Gray_code#Constructing_an_n-bit_Gray_code
        if (n == 0) {
            return Arrays.asList(0);
        }
        List<String> tmp = new ArrayList<>();
        tmp.add("0");
        tmp.add("1");
        for (int i = 1; i < n; i++) {
            List<String> tmp1 = new ArrayList<>();
            for (String binary : tmp) {
                tmp1.add("0" + binary);
            }
            Stack<String> tmp2 = new Stack<>();
            for (String binary : tmp) {
                tmp2.push(binary);
            }
            tmp = new ArrayList<>();
            for (String binary : tmp1) {
                tmp.add(binary);
            }
            while (!tmp2.isEmpty()) {
                tmp.add("1" + tmp2.pop());
            }
        }
        return tmp.stream().map(e -> Integer.parseInt(e, 2)).collect(Collectors.toList());
    }
}
